## **Architecture Decision**
>  ### 5. Decision Title: Error Handling in Rover Simulation
> **Context:** This program account for user inputs that are invalid or need exceptions. We include exception handling to manage both expected and unexpected user errors. Some of the exceptions we use are: IllegalArgumentException, try-catch, and NumberFormatException.
>
> **Strengths(Pros):** There is a continuation in the program despite incorrect input and instead will request for information again from user. Additionally, the error messages are clear so user can input a correct response. 
>
> **Consequences(Cons):** In future development, there may be code complexity with using try-catch exceptions.
>
>
> **Status:** Accepted 