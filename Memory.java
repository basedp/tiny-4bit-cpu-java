public class Memory {
    private MemoryAddress[] memory = new MemoryAddress[16];
    public Memory() {
        for (int i = 0; i < memory.length; i++) {
            memory[i] = new MemoryAddress((byte) i);
        }
    }
    public MemoryAddress get(int index) {
        return memory[index];
    }
    public MemoryAddress[] getMemory() {
        return memory;
    }

}
