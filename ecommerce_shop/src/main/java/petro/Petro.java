package petro;

public class Petro {

    public int n;
    public String txt;

    public Petro(int n, String txt) {
        this.n = n;
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "Petro{" +
                "n=" + n +
                ", txt='" + txt + '\'' +
                '}';
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
