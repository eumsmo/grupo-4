package dn;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class RespostaXML {
    public static String erro(String mensagem, String causa){
        return  "<info>\n"+
                "<erro>\n"+
                "<mensagem>"+mensagem+"</mensagem>\n"+
                "<causa>"+causa+"</causa>\n"+
                "</erro>\n"+
                "</info>";
    }
    
    public static String erro(String mensagem){
        return  "<info>\n"+
                "<erro>\n"+
                "<mensagem>"+mensagem+"</mensagem>\n"+
                "</erro>\n"+
                "</info>";
    }
    
    public static String erro(){
        return erro("Ocorreu um erro!");
    }
    
    public static String sucesso(String mensagem, String causa){
        return  "<info>\n"+
                "<sucesso>\n"+
                "<mensagem>"+mensagem+"</mensagem>\n"+
                "<causa>"+causa+"</causa>\n"+
                "</sucesso>\n"+
                "</info>";
    }
    
    public static String sucesso(String mensagem){
        return  "<info>\n"+
                "<sucesso>\n"+
                "<mensagem>"+mensagem+"</mensagem>\n"+
                "</sucesso>\n"+
                "</info>";
    }
    
    public static String sucesso(){
        return sucesso("Sucesso na operação!");
    }
    
    public static String retornaSet(ResultSet resultados, String ...campos) throws SQLException{
        String resultado = "<info>\n";
        while(resultados.next()){
            String nome = resultados.getMetaData().getTableName(1);
            resultado+="<"+nome+">\n";
            for(String campo: campos){
                String valor = resultados.getString(campo);
                resultado+="<"+campo+">"+valor+"</"+campo+">\n";
            }
            resultado+="</"+nome+">\n";
        }
        return resultado+"</info>";
    }
}
