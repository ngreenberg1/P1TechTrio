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

> ### 2. Decision Title:
