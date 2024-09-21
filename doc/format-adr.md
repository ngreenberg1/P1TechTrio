## **Architecture Decision Records**

> ### 1. Decision Title: Modular Design 
> **Context:** Modularity supports a flexible and maintainable design which assists in the planning of current and future development.
> 
> **Strengths(Pros):** Isolating components makes for easier testing and scalability as new functions can be integrated into the design without affecting the whole system. Using composition, code can be reused avoiding repetition. SRP: classes are smaller with limited reasons for change making them easier to understand in which it assists future development by utilizing the DRY principles. 
>
> **Consequences(Cons):** Increased complexity. Initial set up will be longer for a smaller project like this.
> 
> **Constraints:**
> 
> **Status:** This decision is integrated into this design by the seperation of the classes. There is a location and direction class even though they can be attributes to rover. By making them modular(a seperate component) allows them to be independent moving parts.

> ### 2. Decision Title: Testing Modular
> **Context:** Modular Testing (Unit Testing) is an approach of how specific parts of the system are expected to behave by pinpointing at which module/methods are failing. 
>
> **Strengths(Pros):** This module allows for there to isolated testing to pick up on early bug detection and behavior of each unit test is clear in how Rover and Plateau is supposed to respond. 
>
> **Consequences(Cons):** The Modular testing does not always account for how Rover will interact with different parts of the system leading to limited scopes.   
>
> **Constraints:** Dependencies of classes(Location, Plateau, Rover and Direction) amongst one another to ensure correct ouput. 
>
> **Status:** 
