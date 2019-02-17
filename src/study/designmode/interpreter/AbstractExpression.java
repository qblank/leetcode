package study.designmode.interpreter;

/**
 * @author evan_qb
 * @version 1.0
 * @date 2019/2/17 10:55
 */
public abstract class AbstractExpression {

    /**
     * 解释
     * @param context
     */
    public void interpret(PlayContext context){
        if (context.getText().length() <= 0){
            return;
        }
        String playKey = context.getText().substring(0, 1);
        context.setText(context.getText().substring(2));
        double playValue = Double.parseDouble(context.getText().substring(0, context.getText().indexOf(" ")));
        context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));
        execute(playKey,playValue);
    }

    abstract void execute(String key,double value);
}
