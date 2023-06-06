import javax.swing.*;
import java.util.ArrayList;
import java.util.function.Supplier;

public class App {

    JFrame frame;

    TabbedPanel core;

    ArrayList<Tab> tabs;

    // Initialization

    public void init() {
        initFrame();
        initCore();
        initTabs();

        core.update(createListTab().createBody());

        frame.add(core);

        frame.setVisible(true);
    }

    private void initCore() {
        core = new TabbedPanel();
    }

    private void initFrame() {
        frame = new JFrame();

        frame.setSize(400, 400);
    }

    private void initTabs() {
        tabs = new ArrayList<>(  );

        tabs.add(createRecipieTab());
        tabs.add(createListTab());

        for (Tab tab : tabs) {
            core.addTab(tab);
        }
    }

    private Tab createRecipieTab() {

        return new Tab(core, "Recipies",
                new Supplier<JPanel>( ) {
                    @Override
                    public JPanel get() {

                        JPanel panel = new JPanel(  );

                        JLabel label = new JLabel(  );
                        label.setText("wecipi");

                        panel.add(label);

                        return panel;
                    }
                });
    }

    private Tab createListTab() {
        Tab tab = new Tab(core, "List",
                new Supplier<JPanel>( ) {
                    @Override
                    public JPanel get() {
                        JPanel panel = new JPanel(  );

                        JLabel label = new JLabel(  );
                        label.setText("wist :3");

                        panel.add(label);

                        return panel;
                    }
                });

        return tab;
    }

}
