package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement>{
   public int compare(FSElement element1, FSElement element2) {
    return element1.getSize() - element2.getSize();
   }     
}
