import java.io.Serializable;

public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 7503710091945320739L;

    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

}
