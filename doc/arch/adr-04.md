## **Architecture Decision**
>  ### 2. Decision Title: Grid Boundaries 
> **Context:** This program provides the grid visualization on the console to showcase the plateau and position of the rover after the movement commands. It is represented by these symbols (⋀, >, v, <) which indicates rover's facing direction (north, east, south and west).
>
> **Strengths(Pros):** This decision allows there to be a User-Friendly Visualization of rover's position and facing direction. Additionally, a 2D grid gives a clear representation and easier to maintain.
>
> **Consequences(Cons):** The performance of the grid may need to be further developed if user wants a largeer input grid as rover may move off the board instead of wrapping around.
>
>
> **Status:** Accepted 