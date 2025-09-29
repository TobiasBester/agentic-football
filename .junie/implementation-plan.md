# Agentic Football - Project Plan & Requirements

## Project Vision

Build an object-oriented football simulation engine that progresses from basic physics-based gameplay to sophisticated
AI-controlled agentic behavior, with incremental complexity and multiple interaction interfaces.

## Core Architecture

### Primary Entities

- **Player**: The central entity with attributes, decision-making capabilities, and state modifiers
- **Ball**: Physics-based entity with position, velocity, and interaction mechanics
- **Pitch**: Game environment including boundaries and spatial constraints
- **Goalposts**: Goal detection and scoring mechanics

### Key Systems

- **Attribute System**: Player capabilities that influence decisions and actions
- **Decision Engine**: AUTOMATIC vs AUTONOMOUS action classification
- **State Modifier System**: Dynamic attribute adjustments based on match/environment conditions
- **Match Simulation Engine**: Time-stepped simulation with configurable granularity

## Development Phases

### Phase 1: Core Simulation Foundation (Weeks 1-4)

**Objective**: Basic match simulation with CLI interface

**Deliverables:**

- Core entity classes (Player, Ball, Pitch, Goalposts)
- Basic attribute system with initial attributes (Top Speed, Short Pass Accuracy)
- Match and MatchStep framework (100 steps = 100 seconds initially)
- CLI interface for match state display and step-by-step simulation
- Basic movement and ball interaction mechanics

**Key Technical Decisions:**

- Time step granularity: 1 second per MatchStep
- Initial player attributes to implement
- Basic physics engine for ball movement
- Match state representation format

### Phase 2: Enhanced Simulation Mechanics (Weeks 5-8)

**Objective**: Expand attribute system and decision complexity

**Deliverables:**

- Extended attribute system (shooting, defending, positioning, etc.)
- StateModifier implementation (MatchStateModifiers, EnvironmentStateModifiers)
- More sophisticated decision engine with AUTOMATIC/AUTONOMOUS classification
- Improved physics and collision detection
- Enhanced CLI with better match visualization

**Key Features:**

- Dynamic attribute modification during match
- Weather and stadium effects
- Score-based behavioral changes
- Basic tactical positioning

### Phase 3: Advanced Decision Making (Weeks 9-12)

**Objective**: Rich decision tree and player behavior

**Deliverables:**

- Complex decision scenarios (shoot vs pass vs dribble)
- Team coordination mechanics
- Set piece handling (corners, free kicks, throw-ins)
- Substitution and formation change systems
- Match statistics and analytics

### Phase 4: Graphical Visualization (Weeks 13-16)

**Objective**: Visual match representation while maintaining CLI compatibility

**Deliverables:**

- 2D top-down pitch visualization
- Real-time match playback capabilities
- Player and ball position tracking
- Action visualization (passes, shots, tackles)
- Dual interface (CLI + GUI) architecture

**Technical Options:**

- Java: JavaFX or Swing for desktop visualization
- Python: pygame, matplotlib, or tkinter
- JavaScript: HTML5 Canvas or web-based visualization

### Phase 5: AI Integration Preparation (Weeks 17-20)

**Objective**: Architecture preparation for agentic AI control

**Deliverables:**

- Agent interface abstraction layer
- Decision point externalization
- State representation for AI consumption
- Performance optimization for AI training
- Baseline rule-based AI for comparison

### Phase 6: Agentic AI Implementation (Weeks 21+)

**Objective**: AI-controlled player decision making

**Deliverables:**

- Multi-agent reinforcement learning integration
- Training environment setup
- Agent behavior evaluation metrics
- Self-play and strategy emergence
- Advanced tactical AI behaviors

## Technical Stack Recommendations

### Language Selection Analysis

#### Java (Recommended for your use case)

**Pros:**

- Your existing expertise
- Excellent OOP support
- Strong performance for simulations
- Rich ecosystem for game development
- Good multi-threading capabilities

**Cons:**

- Fewer specialized sports analytics libraries
- More verbose than Python for data analysis
- Limited ML/AI ecosystem compared to Python

**Recommended Libraries:**

- **Physics**: JBox2D for 2D physics simulation
- **CLI**: Apache Commons CLI or picocli
- **Visualization**: JavaFX for modern UI, Processing for creative coding
- **Testing**: JUnit 5 for comprehensive testing
- **Data**: Jackson for JSON serialization, H2 for embedded database

#### Python (Alternative recommendation)

**Pros:**

- Extensive sports analytics ecosystem (pandas, matplotlib, seaborn)
- Rich AI/ML libraries (scikit-learn, pytorch, stable-baselines3)
- Football-specific libraries (mplsoccer, statsbombpy)
- Rapid prototyping capabilities

**Cons:**

- Learning curve if not familiar
- Performance considerations for real-time simulation

**Recommended Libraries:**

- **Simulation**: mesa for agent-based modeling, pygame for real-time simulation
- **AI**: gymnasium for RL environments, stable-baselines3 for RL algorithms
- **Visualization**: matplotlib + mplsoccer for football-specific plots
- **CLI**: click or argparse for command-line interfaces

## Initial Implementation Structure

### Core Classes (Java Example)

```java
// Core entities
public class Player {
    private Map<String, Double> attributes;
    private List<StateModifier> stateModifiers;
    private Position position;
    private PlayerRole role;

    public Decision makeDecision(MatchContext context);

    public void executeAction(Action action, double deltaTime);
}

public class Match {
    private List<Player> players;
    private Ball ball;
    private Pitch pitch;
    private MatchState currentState;
    private int currentStep;
    private final int MAX_STEPS = 100;

    public void simulateStep();

    public void simulateSteps(int numSteps);
}

// Decision system
public abstract class Decision {
    public abstract void execute(Player player, MatchContext context);
}

public class AutomaticDecision extends Decision {
    // Rule-based automatic behaviors
}

public class AutonomousDecision extends Decision {
    // Complex decision-making logic
}
```

## Success Metrics & Evaluation

### Phase 1 Success Criteria

- Match simulation runs for 100 steps without crashes
- CLI displays meaningful match state information
- Basic player movement and ball interactions work
- At least 3 core attributes affect gameplay noticeably

### Phase 2 Success Criteria

- StateModifiers visibly affect player behavior
- Weather/environment changes impact match dynamics
- Players make contextually appropriate automatic decisions
- Match outcomes vary based on team attributes

### Long-term Success Criteria

- Realistic match dynamics and scorelines
- Emergent tactical behaviors from AI agents
- Performance suitable for real-time visualization
- Extensible architecture for adding new features

## Risk Mitigation

### Technical Risks

- **Performance bottlenecks**: Profile early, optimize critical paths
- **Complexity creep**: Strict phase-based development, clear scope boundaries
- **AI integration challenges**: Design agent interfaces from Phase 1

### Project Risks

- **Feature scope expansion**: Document feature freeze points for each phase
- **Time estimation**: Build in buffer time for debugging and refinement
- **Technology learning curve**: Start with familiar tools, gradually introduce new ones

## Development Tickets - Sprint 1 (Phase 1 Foundation)

### TICKET AF-001: Project Setup & Basic Entity Framework

**Priority**: High | **Estimate**: 1 day
**Goal**: Establish project structure with core entities that can be instantiated and display basic information

**Acceptance Criteria**:

- Java project with proper package structure (com.agenticfootball.entities, etc.)
- Player class with constructor accepting name, position, and 3 basic attributes (speed, passing, shooting)
- Ball class with position (x, y coordinates)
- Pitch class with dimensions and boundary checking methods
- Simple main() method that creates 2 players, 1 ball, 1 pitch and prints their toString() representations
- All classes have meaningful toString() methods for debugging

**Definition of Done**: Can run the main method and see readable output of all entities

---

### TICKET AF-002: Match Container & Basic Time Stepping

**Priority**: High | **Estimate**: 1 day
**Goal**: Create a Match that can hold entities and advance through time steps with basic CLI interaction

**Acceptance Criteria**:

- Match class that holds 10 players (5v5), 1 ball, 1 pitch
- MatchStep counter that increments from 0 to configurable maximum (default 100)
- CLI command "step" advances one MatchStep and shows current step number
- CLI command "step X" advances X steps
- CLI command "status" shows match time, score (0-0 for now), and number of players per team
- Each MatchStep takes configurable time duration (default 1000ms for testing, but stored as 1 second game time)

**Definition of Done**: Can run CLI commands to step through a match and see time progression

---

### TICKET AF-003: Player Positioning & Basic Movement

**Priority**: High | **Estimate**: 1 day  
**Goal**: Players have positions on the pitch and can move toward target locations

**Acceptance Criteria**:

- Player class has Position (x, y) with getter/setter
- Players start in basic 5v5 formation positions (can be hardcoded initially)
- Each MatchStep, players can move toward a target position based on their Speed attribute
- Movement is capped by realistic distance per second (e.g., max 10 meters/second for fastest players)
- CLI "positions" command shows all player positions in readable format
- CLI "field" command shows a simple ASCII representation of pitch with player positions (use letters/numbers for
  players)

**Definition of Done**: Can see players moving on the ASCII field representation over multiple steps

---

### TICKET AF-004: Ball Physics & Player-Ball Interaction

**Priority**: High | **Estimate**: 1 day
**Goal**: Ball has realistic physics and players can interact with it based on proximity

**Acceptance Criteria**:

- Ball has velocity (vx, vy) and updates position each MatchStep
- Ball velocity decreases each step due to friction (realistic deceleration)
- Ball bounces off pitch boundaries with reduced velocity
- Players within 2 meters of ball can "interact" with it (touch/control)
- When player interacts with ball, ball velocity changes based on player's action
- CLI shows ball position and velocity in status display
- CLI "field" shows ball position (use * or O) alongside players

**Definition of Done**: Can see ball moving, slowing down, bouncing, and being affected by nearby players

---

### TICKET AF-005: Basic Decision Engine Framework

**Priority**: Medium | **Estimate**: 1 day
**Goal**: Players make simple AUTOMATIC decisions each step based on game state

**Acceptance Criteria**:

- Decision interface with execute() method
- AutomaticDecision subclass for rule-based decisions
- Players have makeDecision() method that returns a Decision based on current context
- Implement 2 simple automatic decisions: "MoveToPosition" and "ChaseOBall"
- Players choose between these based on simple rules (chase ball if within 15 meters, otherwise return to position)
- Each MatchStep, all players make and execute their decisions
- CLI shows what decision each player made in the last step (optional debug mode)

**Definition of Done**: Players automatically chase ball when close, return to formation when far, creating basic
emergent behavior

---

### TICKET AF-006: Simple Passing Mechanics

**Priority**: Medium | **Estimate**: 1 day
**Goal**: Players can pass the ball to teammates with accuracy based on attributes

**Acceptance Criteria**:

- New AutonomousDecision: "PassToTeammate"
- Players with ball possession can choose to pass to nearest teammate
- Pass accuracy affected by player's Passing attribute and distance to target
- Failed passes result in ball going in slightly wrong direction
- Successful passes give ball to target teammate
- Possession tracking: Match tracks which player (if any) currently "has" the ball
- CLI shows possession changes and pass attempts/results

**Definition of Done**: Can see players passing ball between teammates with varying success rates based on their
attributes

This approach gives you working, testable software after each ticket while building toward the larger vision. Each
ticket should take roughly a day and adds visible functionality you can interact with via the CLI.