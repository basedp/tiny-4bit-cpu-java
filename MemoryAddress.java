public class MemoryAddress {
    private byte Address;
    private short content;


    public MemoryAddress(byte Address) {
        //this.Address = (byte) (Address & 0x0F);
        setAddress(Address);
    }

    public void setAddress(byte Address){
        //limit length to 4 bits
        //using a mask im able to limit to only the 4 lower bits getiing 16 address
        this.Address = (byte) (Address & 0x0F);
    }
    public  byte getAdress(){
        return Address;

    }
    @Override
    public String toString(){
        return Integer.toBinaryString(Address); // converts the int to a binary string e.g "1101111"
    }
}
