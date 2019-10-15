package com.nailshair.salao.api.venda.pedido;

public enum TipoDePagamento {

    DINHEIRO                    {@Override public String toString(){return "Dinheiro"	                 ;}},
    CARTAO_DE_CREDITO           {@Override public String toString(){return "Cartão de Crédito"	         ;}},
    CARTA_DE_DEBITO             {@Override public String toString(){return "Carta de Débito"	         ;}},
    CHEQUE                      {@Override public String toString(){return "Cheque"	                     ;}},
    TRANSFERENCIA_ELETRONICA    {@Override public String toString(){return "Transferência Eletrônica"	 ;}}

}
