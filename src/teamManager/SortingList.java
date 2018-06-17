/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

/**
 *
 * @author San
 */
public class SortingList {
    private InterfaceSort sorter = null;

    public InterfaceSort getSorter() {
        return sorter;
    }

    public void setSorter(InterfaceSort sorter) {
        this.sorter = sorter;
    }

    public void sortTreeSet() {
        sorter.sort();
    }
}
