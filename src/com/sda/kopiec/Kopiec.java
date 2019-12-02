package com.sda.kopiec;

public class Kopiec {
    int[] kopiec = new int[20];
    int end = 0;
    int rodzicIndex;
    int biezacyIndex;
    boolean czyZamienic = true;

    public void add(int wartosc) {
        czyZamienic = true;
        if (end == 0) {
            kopiec[0] = wartosc;
            end++;
        } else {
            kopiec[end] = wartosc;
            biezacyIndex = end;

            while ((biezacyIndex > 0) && czyZamienic == true) zamienWezly(biezacyIndex);
            end++;
        }

    }

    public int pop() {

        int zwracana = kopiec[0];
        kopiec[0] = kopiec[end];
        biezacyIndex = 0;
        czyZamienic = true;

        while ((rodzicIndex < end) && czyZamienic == true)
            zamienWezlyWDol(rodzicIndex);
        end--;

        return zwracana;

    }
public void zamienWezlyWDol(int rodzicIndex) {
        int syn1Index = 2*rodzicIndex + 1;
        int syn2Index = 2*rodzicIndex + 2;

        if (kopiec[syn1Index] > kopiec[syn2Index])
            biezacyIndex = syn1Index;
        else biezacyIndex = syn2Index;

        if (kopiec[rodzicIndex] < kopiec[biezacyIndex]) {
            int temp = kopiec[rodzicIndex];
            kopiec[rodzicIndex] = kopiec[biezacyIndex];
            kopiec[biezacyIndex] = temp;
            this.rodzicIndex = biezacyIndex;
            czyZamienic = true;
        }else czyZamienic = false;
        }

    public boolean zamienWezly(int biezacyIndex){
        System.out.println("biezacyIndex: "+ biezacyIndex+ " rodzicaIndex: "+ rodzicIndex);
        System.out.println("Index Wartosc: "+ kopiec[biezacyIndex]+" Rodzic Wartość: "+ kopiec[rodzicIndex]);

        rodzicIndex = (biezacyIndex -1)/2;

        if (kopiec[biezacyIndex] > kopiec[rodzicIndex]){
            System.out.println("Bedzie zamiana");
            int temp;
            temp = kopiec[biezacyIndex];
            kopiec[biezacyIndex] = kopiec[rodzicIndex];
            kopiec[rodzicIndex] = temp;
            System.out.println("Index wartosc: "+kopiec[biezacyIndex]+" Rodzic wartosc: "+ kopiec[rodzicIndex]);
            this.biezacyIndex = rodzicIndex;
            System.out.println("Biezacy index ma teraz wartosc: "+ this.biezacyIndex);
            return true;
         }else {
            czyZamienic = false;
            return false;
        }
    }
    public void show() {
        for (int elKopca : kopiec) {
            System.out.print(elKopca + " ");
        }
        System.out.println();
    }
}
