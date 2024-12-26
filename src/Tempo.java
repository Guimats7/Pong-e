public class Tempo {
    public static double tempoInicio = System.nanoTime();

    public static double getTempo() {return (System.nanoTime() - tempoInicio) * 1E-9;}
}
