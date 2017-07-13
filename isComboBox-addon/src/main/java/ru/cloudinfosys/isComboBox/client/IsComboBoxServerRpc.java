package ru.cloudinfosys.isComboBox.client;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

// ServerRpc is used to pass events from client to server
public interface IsComboBoxServerRpc extends ServerRpc {

    public void selectBtnClick();
    public void openBtnClick();

}
