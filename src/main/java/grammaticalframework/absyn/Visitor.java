package grammaticalframework.absyn;

/**
 * Created by me on 8/7/15.
 */
public interface Visitor<R, A> {
    
    public R visit(Lambda p, A arg);

    public R visit(Variable p, A arg);

    public R visit(Application p, A arg);

    public R visit(Literal p, A arg);

    public R visit(MetaVariable p, A arg);

    public R visit(Function p, A arg);

}
