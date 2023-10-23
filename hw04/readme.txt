# Gearbox with State Design Pattern

The Gearbox with State Design Pattern is a Java implementation that demonstrates the State design pattern. 
It models the behavior of shifting gears in a vehicle using a gearbox, such as a manual transmission. 
The State design pattern allows an object to alter its behavior when its internal state changes, providing a cleaner way to manage state-specific behavior.

## Classes and Interfaces

### State (Interface)
- This interface defines the contract for all gear state classes. 
It contains two methods: `gearUp` and `gearDown`, which handle shifting up and down through the gears.

### Gear1, Gear2, Gear3, Gear4, and Gear5 (Classes)
- These classes represent the different gear states. Each class implements the `State` interface and defines the behavior for shifting up and down between gears.
- For example, `Gear1` is the lowest gear, and it implements `gearUp` and `gearDown` methods to manage the transition between Gear 1 and Gear 2.

### Gearbox (Class)
- The `Gearbox` class maintains the current gear state using a reference to the current `State` object. 
- It provides methods for shifting gears, including `gearUp` and `gearDown`.
- The `setState` method is used to change the current state when shifting gears, and the `getCurrentState` method allows retrieving the current gear state.

## Usage

```java
// Create a Gearbox and initialize with Gear 1
Gearbox gearbox = new Gearbox();

// Shifting up
gearbox.gearUp(); // Shifts to the next higher gear
gearbox.gearUp(); // Shifts to the next higher gear
// ...
gearbox.gearUp(); // Shifts to the highest gear (Gear 5)

// Shifting down
gearbox.gearDown(); // Shifts to the previous lower gear
gearbox.gearDown(); // Shifts to the previous lower gear
// ...
gearbox.gearDown(); // Shifts to the lowest gear (Gear 1)
