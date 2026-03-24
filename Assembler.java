import java.util.regex.*;

public class Assembler {
    //takes instructions like ADD,0001,0010
    //and transforms it to something like  0000_0010_0001_0010
    // if we add mode  d'addressage then we'll have $ ADD,0001,0010
    // so the result wil be : 0001_0010_0001_0010

    private String instruction;
    private Short b_instruction;

    public Assembler(String instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException("instruction null");
        }

        if (instruction.replace(" ", "").length() > 14) {
            throw new IllegalArgumentException("instruction invalide");
        }

        this.instruction = instruction;
    }

    // from String to bin instruction
//    public String firstpart(String instruction){
//        if (instruction.charAt(0)!= '$' && instruction.charAt(0)!= '/' ){
//
//        String opcode = instruction.toUpperCase().substring(0,instruction.indexOf(",")) ;
//        return opcode;}
//        else {
//            String mode = instruction.substring(0,1);
//            String opcode = instruction.toUpperCase().substring(1,instruction.indexOf(","));
//        }
//    }

    public String[] firstpart(String instruction) {
        if (instruction.charAt(0) != '$' && instruction.charAt(0) != '/') {
            String opcode = instruction.toUpperCase().substring(0, instruction.indexOf(","));
            return new String[]{opcode, ""};
        } else {
            String mode = instruction.substring(0, 1);
            String opcode = instruction.toUpperCase().substring(1, instruction.indexOf(","));
            return new String[]{opcode, mode};
        }
    }

    public String secondpart(String instruction){
        String operand_1 = "";
        String input = instruction.toUpperCase();
        Pattern p = Pattern.compile(",([^,]+),");
        Matcher m = p.matcher(input);
        if (m.find()) {
            //IO.println(m.group(1));
            operand_1 = m.group(1);
        }
        return operand_1;
    }
    public String thirdpart(String instruction){
        String operand_2 = instruction.toUpperCase().substring(instruction.lastIndexOf(",")+1,instruction.length());
        return operand_2;

    }


    //lets match the instruction to its binary
    public short opcodet(String instruction, short b_instruction) {
//        String opcode = firstpart(instruction);

        String[] parts = firstpart(instruction);
        String opcode = parts[0];
        String mode = parts[1];
        String operand1 = secondpart(instruction);
        String operand2 = secondpart(instruction);
        if (!mode.equals("")){
            switch (mode){
                case "$":
                    b_instruction = (short) (b_instruction | 0x1000);
                    break;
                case "/":
                    b_instruction = (short) (b_instruction | 0x2000);
                    break;
        }
        }

        switch (opcode) {
            case "LOAD":
                b_instruction = (short) (b_instruction | 0x0100);
                break;
            case "ADD":
                b_instruction = (short) (b_instruction | 0x0200);
                break;
            case "SUB":
                b_instruction = (short) (b_instruction | 0x0300);
                break;
            case "AND":
                b_instruction = (short) (b_instruction | 0x0400);
                break;
            case "OR":
                b_instruction = (short) (b_instruction | 0x0500);
                break;
            case "XOR":
                b_instruction = (short) (b_instruction | 0x0600);
                break;
            case "NAND":
                b_instruction = (short) (b_instruction | 0x0700);
                break;
            case "DIV":
                b_instruction = (short) (b_instruction | 0x0800);
                break;
            case "INC":
                b_instruction = (short) (b_instruction | 0x0A00);
                break;
            case "MOVE":
                b_instruction = (short) (b_instruction | 0x0B00);
                break;
            case "SAL":
                b_instruction = (short) (b_instruction | 0x0C00);
                break;
            case "SAR":
                b_instruction = (short) (b_instruction | 0x0E00);
                break;
            default:
                throw new IllegalArgumentException("Unknown opcode: " + opcode);
        }
        switch (operand1){
//            case "R":
//            case "R1":
//            case "R2":
//            case "R3":
//            case "A":
//            case "B":



        }


        return b_instruction;
    }

    public void getInstruction(){}
    public void getopcode(){}
    public void getmode(){}
    public void getoperande1(){}
    public void getoperande2(){}




}
