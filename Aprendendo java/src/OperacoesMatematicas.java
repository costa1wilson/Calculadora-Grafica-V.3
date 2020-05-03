
import javax.swing.JFrame;
import javax.swing.JInternalFrame;



/**
 *
 * @author wilson costa
 */
public class OperacoesMatematicas {
     
    
    public double soma(double n1,double n2){
    return n1 + n2;
    }
    public double multiplicaco(double n1,double n2){
    return n1 * n2;
    }
    public double divisao(double n1,double n2){
        if(n1==0||n2==0){
        return 0;
        }else{
    return n1 / n2;
        }
    }
    public double subtracao(double n1,double n2){
    return n1 - n2;
    }

}
