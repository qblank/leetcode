package study.designmode.interpreter;

/**
 * @version 1.0
 * @date 2019/2/17 11:02
 */
public class Note extends AbstractExpression {

    @Override
    void execute(String key, double value) {
        String note = "";
        switch (key){
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
            default:
                note = "1";
                break;
        }
        System.out.print(note + " ");
    }
}
