package interfaz.dialogs;

import interfaz.InterfazSpaceInvaders;

import java.util.Collection;

public interface DialogBuilderWithLists {

    void setLayout(InterfazSpaceInvaders interfaz);
    void reset();
    void getResult();

    void changeList(Collection lista);

}
