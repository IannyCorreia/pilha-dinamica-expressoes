public class VerificadorExpressoes {
    public boolean verificaExpressao(String expressao) {
        if (expressao == null || expressao.trim().isEmpty()) {
            System.out.println("Erro: Expressão vazia ou nula fornecida.");
            return false;
        }

        Pilha pilha = new Pilha();

        try {
            for (int i = 0; i < expressao.length(); i++) {
                char caractere = expressao.charAt(i);

                if (Character.isDigit(caractere) || "+-*/".indexOf(caractere) != -1 || caractere == ' ') {
                    continue;
                }
                else if (caractere == '(' || caractere == '{' || caractere == '[') {
                    pilha.empilhar(caractere);
                } 
                else if (caractere == ')' || caractere == '}' || caractere == ']') {
                    if (pilha.isEmpty()) {
                        System.out.println("Erro: Parênteses, chaves ou colchetes não balanceados.");
                        return false;
                    }

                    char topo = pilha.desempilhar();

                    if ((caractere == ')' && topo != '(') ||
                        (caractere == '}' && topo != '{') ||
                        (caractere == ']' && topo != '[')) {
                        System.out.println("Erro: Fechamento incorreto dos delimitadores.");
                        return false;
                    }
                } 
                else {
                    throw new CaracterInvalidoException("Erro: Caractere inválido encontrado: " + caractere);
                }
            }

            if (!pilha.isEmpty()) {
                System.out.println("Erro: Expressão incompleta. Faltam fechamentos.");
                return false;
            }

        } catch (CaracterInvalidoException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalStateException e) {
            System.out.println("Erro durante o processamento: " + e.getMessage());
            return false;
        }

        return true;
    }
}