import javax.swing.*;
import java.util.ArrayList;

public class TabbedPanel extends JPanel {
    ArrayList<Tab> tabList;
    private JPanel tabs;
    private JPanel body;

    public TabbedPanel() {
        tabList = new ArrayList<>(  );

        JPanel tabs = new JPanel(  );
        JPanel body = new JPanel(  );

        update(createDefaultPanel());
    }

    public void addTab(Tab tab) {
        tabList.add(tab);
    }

    private JPanel createTabPanel() {
        JPanel tabPanel = new JPanel(  );
        tabList.forEach(tabPanel::add);
        tabPanel.setLayout(new BoxLayout(tabPanel, BoxLayout.X_AXIS));

        return tabPanel;
    }

    public void update(JPanel panel) {
        this.removeAll();

        this.tabs = createTabPanel();
        this.body = panel;

        this.add(tabs);
        this.add(body);

        this.setVisible(false);
        this.setVisible(true);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private JPanel createDefaultPanel() {
        return new JPanel(  );
    }
}
