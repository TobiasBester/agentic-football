Agentic Football — Project Guidelines

Audience: Advanced Java developers working on the Agentic Football match engine (Maven project).

Core concepts and architecture
- Object types: The engine is intentionally split into three object categories (see org.coolandfunandnice.matchengine.Match):
  - Info objects: immutable, data-only (e.g., MatchInfo, TeamInfo, PlayerInfo, Pitch, Ball). These should be thread-safe and serializable-friendly; do not add behavior.
  - State objects: mutable, data-only representing runtime state (e.g., MatchBall, MatchPlayer, MatchTeam). Keep their behavior minimal; logic should live in operators.
  - Operator objects: mutable components that encapsulate behavior and operate on State objects (e.g., MatchBallOperator, MatchTeamOperator, MatchPlayerOperator). This separation enables clearer testing and simulation control.
- Factory layer: Construction of Info/State/Operator graphs is centralized in factory classes (e.g., MatchFactory, TeamFactory, PlayerFactory). Prefer adding new construction logic here rather than scattering in app code.
- Determinism and randomness: Team and player factories use Math.random() for ad-hoc randomness. For reproducible simulations, introduce a seeded Random and thread it through factories instead of calling Math.random() directly.

Build and runtime prerequisites
- Java version: The codebase uses Java language features such as records (e.g., MatchTeam is a record), which require Java 16+. The current pom.xml sets:
  - maven.compiler.source = 25
  - maven.compiler.target = 25
  You must build with a JDK that supports at least that level (prefer JDK 21+ LTS or the exact version 25 configured in pom.xml).
- Maven: Project is a standard Maven module located at agentic-football-app.

Recommended Java setup via Maven Toolchains (preferred)
- Keep pom.xml source/target as-is and configure Maven to use a modern JDK without modifying developers’ default JDK:
  1) Install a suitable JDK (e.g., JDK 21+ or JDK 25 EA if targeting 25).
  2) Create ~/.m2/toolchains.xml (Windows: %USERPROFILE%\.m2\toolchains.xml) with an entry matching your installed JDK. Example for JDK 21:
     <toolchains>
       <toolchain>
         <type>jdk</type>
         <provides>
           <version>21</version>
           <vendor>any</vendor>
         </provides>
         <configuration>
           <jdkHome>C:\\Java\\jdk-21</jdkHome>
         </configuration>
       </toolchain>
     </toolchains>
  3) Optionally add the Maven Toolchains Plugin to enforce JDK usage in CI.

Alternative (not recommended): Downgrade source/target
- You can lower source/target in pom.xml only if you also remove language features not supported by the lower JDK (e.g., records). This is a larger refactor and generally not advised.

Build instructions
- Module root: agentic-football-app
- Clean build:
  - mvn -q -e -DskipTests clean package
- Full build with tests:
  - mvn -q -e test
- If you see compilation failures about unsupported source/target, confirm your Maven is using the intended JDK. Run mvn -v and ensure Java version is >= the pom’s source/target. If not, set up toolchains as above or switch JAVA_HOME/Path temporarily for the build.

Testing
- Frameworks: JUnit 5 (Jupiter) with Maven Surefire Plugin 3.2.5.
- Location: src/test/java under the module.
- Naming: Standard JUnit naming is supported; no special suffixes required when using JUnit 5 + Surefire 3.x.
- Running tests:
  - All tests: mvn -q test
  - Single test class: mvn -q -Dtest=org.coolandfunandnice.matchengine.factory.MatchFactoryTest test
  - Single method: mvn -q -Dtest=org.coolandfunandnice.matchengine.factory.MatchFactoryTest#createRandomMatch_withOnePlayerPerTeam_returnsNonNullMatchAndDoesNotThrowOnBasicOps test
- Current example test: org.coolandfunandnice.matchengine.factory.MatchFactoryTest
  - It smoke-tests MatchFactory.createRandomMatch and basic Match public methods.
  - It also asserts that creating a match with 0 players throws IllegalArgumentException.
- Adding tests:
  - Prefer testing Operators (behavior) rather than State or Info.
  - For factories, create minimal, deterministic variants (e.g., inject a seeded Random) to make tests reliable.
  - Use JUnit 5 Assertions and lifecycle annotations. Keep tests hermetic; do not rely on external state.

Executing the application
- Entry point: org.coolandfunandnice.Main (under src/main/java). If you need to run the app from Maven, consider adding the Maven Exec Plugin:
  <plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.5.0</version>
    <configuration>
      <mainClass>org.coolandfunandnice.Main</mainClass>
    </configuration>
  </plugin>
  Then run: mvn -q exec:java

Code style and conventions
- Immutability by default for Info records; avoid adding mutators.
- Prefer records for simple data carriers where appropriate.
- Keep Operator classes small and single-responsibility; aggregate behavior behind them rather than leaking logic into State objects.
- Use factory classes for cross-cutting construction logic. Avoid assembling object graphs in application entry points.
- Favor clear method/field naming: suffix Operator for operator classes; suffix Info for immutable descriptors; prefix Match for in-match entities.

Debugging tips
- Start with Match.printMatchInfo() and printDetailedMatchState() to understand setup.
- Operators often have reset() methods; use them to bring the simulation back to a known state between tests.
- If randomness impedes debugging, add constructors/factory methods that accept a Random instance.

CI considerations
- Ensure CI uses a compatible JDK (>= pom.xml source/target). Using Maven Toolchains in CI is the most reliable approach.
- Cache the local Maven repository to speed up builds.

Known caveats
- Tests will fail to compile if the Maven JVM is older than the configured source/target in pom.xml. Align JDKs accordingly.
- The current factories generate random players and team names; expected outputs vary between runs unless made deterministic.

Housekeeping
- Keep transient or experimental scripts out of version control.
- If you add any helper files for testing locally, remove them before committing unless they are reusable for the team.
