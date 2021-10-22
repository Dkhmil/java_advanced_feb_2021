package petro;

public class Petro {

    public int nameVar;
    public String txt;

    public Petro(int n, String txt) {
        this.nameVar = n;
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "Petro{" +
                "n=" + nameVar +
                ", txt='" + txt + '\'' +
                '}';
    }

    public int getN() {
        return nameVar;
    }

    public void setN(int n) {
        this.nameVar = n;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
