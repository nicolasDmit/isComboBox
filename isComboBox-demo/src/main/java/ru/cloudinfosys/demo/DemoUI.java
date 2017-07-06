package ru.cloudinfosys.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import ru.cloudinfosys.IsComboBox;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("IsComboBox Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "ru.cloudinfosys.DemoWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    private static final String CAPTION_PROPERTY = "caption";
    private static final String DESCRIPTION_PROPERTY = "description";
    private static final String INDEX_PROPERTY = "index";
    private static final String DISABLED = "disabled";

    @SuppressWarnings("unchecked")
    private static IndexedContainer generateContainer(final int size, final boolean hierarchical) {
        final IndexedContainer container = hierarchical ? new HierarchicalContainer() : new IndexedContainer();
        final StringGenerator sg = new StringGenerator();
        container.addContainerProperty(CAPTION_PROPERTY, String.class, null);

        container.addContainerProperty(INDEX_PROPERTY, Integer.class, null);
        container.addContainerProperty(DESCRIPTION_PROPERTY, String.class, null);
        container.addContainerProperty(DISABLED, Boolean.class, false);

        for (int i = 1; i < size + 1; i++) {
            final Item item = container.addItem(i);
            item.getItemProperty(CAPTION_PROPERTY)
                    .setValue(sg.nextString(true) + " " + sg.nextString(false));
            item.getItemProperty(INDEX_PROPERTY)
                    .setValue(i);
            item.getItemProperty(DESCRIPTION_PROPERTY)
                    .setValue(sg.nextString(true) + " " + sg.nextString(false) + " " + sg.nextString(false));
            item.getItemProperty(DISABLED)
                    .setValue(i % 2 > 0);

        }

        if (hierarchical) {
            for (int i = 1; i < size + 1; i++) {
                for (int j = 1; j < 5; j++) {
                    final String id = i + " -> " + j;
                    Item child = container.addItem(id);
                    child.getItemProperty(CAPTION_PROPERTY)
                            .setValue(sg.nextString(true) + " " + sg.nextString(false));


                    ((Container.Hierarchical) container).setParent(id, i);

                    for (int k = 1; k < 6; k++) {
                        final String id2 = id + " -> " + k;
                        child = container.addItem(id2);
                        child.getItemProperty(CAPTION_PROPERTY)
                                .setValue(sg.nextString(true) + " " + sg.nextString(false));

                        ((Container.Hierarchical) container).setParent(id2, id);

                        for (int l = 1; l < 5; l++) {
                            final String id3 = id2 + " -> " + l;
                            child = container.addItem(id3);
                            child.getItemProperty(CAPTION_PROPERTY)
                                    .setValue(sg.nextString(true) + " " + sg.nextString(false));

                            ((Container.Hierarchical) container).setParent(id3, id2);
                        }
                    }
                }
            }
        }

        return container;
    }

    @Override
    protected void init(VaadinRequest request) {

        // Initialize our new UI component
        final IsComboBox component = new IsComboBox();

        component.setOpenByClick(true);

        IndexedContainer indexedContainer = generateContainer(100, false);

        component.setContainerDataSource(indexedContainer);

        component.setItemCaptionPropertyId(CAPTION_PROPERTY);
        component.setItemDisabledPropertyId(DISABLED);

//        component.setItemEnabled(4, false);
//        component.setItemEnabled(5, false);
//        component.setItemEnabled(6, false);

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");
        layout.setSizeFull();
        layout.addComponent(component);
        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
        setContent(layout);
    }
}
