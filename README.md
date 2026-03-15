# tiny-4bit-cpu-java

Trying to build a CPU from scratch in Java alongside my computer architecture
course. Simulates a 16-address memory space and the classic fetch → decode → 
execute cycle, no emulation libraries involved.

## Architecture

Follows the Von Neumann architecture instructions and data share the same
16-cell memory space, accessed sequentially
