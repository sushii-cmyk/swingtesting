import java.awt.*;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.*;

public class Tab extends JButton implements ITab {

    private TabbedPanel parent;
    private final String name;

    Supplier<JPanel> createBody;

    public Tab(TabbedPanel parent, String name, Supplier<JPanel> createBody) {
        super();
        this.parent = parent;
        this.name = name;
        this.createBody = createBody;

        initListener();

        this.setText(name);
    }

    private void initListener() {
        this.addActionListener(e -> {
            this.onClick();
        });
    }

    @Override
    public void onClick() {
        parent.update(this.createBody.get());
    }

    @Override
    public JPanel createBody() {
        return this.createBody.get();
    }
}
