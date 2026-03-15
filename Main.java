import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        MemoryAddress A = new MemoryAddress((byte) 0b110_1111); //example
        byte ef = A.getAdress();
        IO.println(ef);//decimal output
        IO.println(Integer.toBinaryString(ef)); // binary output

        //initialize memory [0, 1, 10, 11, 100, 101, 110, 111, 1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111]
        Memory memory = new Memory();
        System.out.println(Arrays.toString(memory.getMemory()));

        // registers
        short R1  , adressRegister ,  state_register , Acc ;
        short Pc = 0x00; // pc points to the next instruction in memory
        IO.println(Pc);
        // after increment in the cpu cycle loop do this to keep only the last 4 bits Pc = (byte)( Pc & 0x0f );






}
//cpu cycle should be in a while loop and after each cycle Pc GETTS incremented by one

    public void fetch() {}
    public void decode() {}
    public void execute() {}
}