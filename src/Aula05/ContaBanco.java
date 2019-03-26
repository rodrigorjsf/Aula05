package Aula05;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual(){
        System.out.println("---------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC"){
            this.setSaldo(50);
        }else if(t == "CP"){
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }
    public void fecharConta(){
        if(this.getSaldo() > 0){
            System.out.println("Conta não pode ser fechada porque ainda tem dinheiro.");

        }else if(this.getSaldo() < 0){
            System.out.println("Conta não pode ser fechada pois tem débito");
        }else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }
    public void depositar(float v){
        if (this.getStatus()){
            //this.saldo = this.saldo + v;
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Depósito realizado na conta de " + this.getDono());
        }else {
            System.out.println("Impossível depositar em uma conta fechada!");
        }
    }
    public void sacar(float v){
        if(this.getStatus()){
            if(this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado com sucesso!");
            }else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Impossivel sacar de uma conta fechada!");
        }
    }
    public void pagarMensal(){
        float v = 0;
        if(this.getTipo().equals("CC")){
            v = 12;
        } else if (this.getTipo().equals("CP")){
            v = 20;
        }if(this.getStatus()){
            if(this.getSaldo() > v){
                this.setSaldo(this.getSaldo() - v) ;
                System.out.println("Mensalidade paga com sucesso!");
            }else {
                System.out.println("Saldo Insuficiente.");
            }
        }else {
            System.out.println("Impossivel efetuar pagamento de uma conta fechada!");
        }
    }

    //Metodos especiais

    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int n) {
        this.numConta = n;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getDono() {
        return this.dono;
    }

    public void setDono(String d) {
        this.dono = d;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float s) {
        this.saldo = s;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean sts) {
        this.status = sts;
    }
}
