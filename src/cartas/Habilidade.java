package cartas;

import Enum.Efeito;

public enum Habilidade {
    // Criaturas
    EXPLOSAO_IGNEA(Efeito.MUITO_DANO),
    CONGELAMENTO_ABSOLUTO(Efeito.DANO),
    SOPRO_FLAMEJANTE(Efeito.DANO),
    SOPRO_CONGELANTE(Efeito.DANO),
    EMBOSCADA_SURPRESA(Efeito.DANO),
    ESCUDO_CONGELADO(Efeito.DANO),
    TIRO_PRECISO(Efeito.MUITO_DANO),
    FLECHA_INCANDESCENTE(Efeito.DANO),
    GOLPE_SILENCIOSO(Efeito.MUITO_DANO),
    FORCA_PRIMORDIAL(Efeito.MUITO_DANO),
    LABAREDA_INFERNAL(Efeito.DANO),
    MARTELO_FLAMEJANTE(Efeito.MUITO_DANO),
    UIVO_GELIDO(Efeito.DANO),
    TREMOR_DE_TERRA(Efeito.DANO),
    PELE_DE_PEDRA(Efeito.DANO),
    FOGO_DA_TERRA(Efeito.DANO),
    VISAO_AGUCADA(Efeito.DANO),
    LAMINA_VELOZ(Efeito.MUITO_DANO),
    REVIVER_FEITICEIRO(Efeito.REVIVER),
    REVIVER_FENIX(Efeito.REVIVER),
    ONDA_EXPLOSIVA(Efeito.MUITO_DANO),
    CHAMA_VITAL(Efeito.DANO),
    ABRACO_DE_URSO(Efeito.MUITO_DANO),
    CANTO(Efeito.DANO),
    CONTO(Efeito.DANO),
    INVESTIDA(Efeito.DANO),
    GARRAS_DE_LAVA(Efeito.MUITO_DANO),
    AVALANCHE(Efeito.DANO),
    CURA_NATURAL(Efeito.VIDA),
    RESTAURACAO_DE_PODER(Efeito.MANA),
    SOMBRA_VELOZ(Efeito.DANO),
    RAIO_DESTRUTIVO(Efeito.MUITO_DANO),
    MORTE_SILENCIOSA(Efeito.DANO),
    LEALDADE(Efeito.MUITA_VIDA),
    CURA(Efeito.VIDA),
    BALDE_DE_MANA(Efeito.MUITA_MANA),
    FLECHAS_CONGELANTES(Efeito.DANO),
    EXECUCAO(Efeito.MUITO_DANO),
    CURA_SOMBRIA(Efeito.MUITA_VIDA),
    FEITICO_DE_VIDA(Efeito.VIDA),

    // Feitiços
    BOLA_DE_FOGO(Efeito.MUITO_DANO),
    TEMPESTADE_DE_GELO(Efeito.DANO),
    TEMPESTADE(Efeito.DANO),
    ESPINHOS_SELVAGENS(Efeito.DANO),
    FURIA_VULCANICA(Efeito.MUITO_DANO),
    NECROMANCIA(Efeito.REVIVER),
    REGENERACAO_PROFUNDA(Efeito.MUITA_VIDA),
    ENERGIZAR(Efeito.MANA),
    RAIO_DE_ESPERANCA(Efeito.VIDA),
    TOQUE_DE_VIDA(Efeito.VIDA),

    // Encantamentos
    FAISCAS(Efeito.DANO),
    ESTALAGMITES(Efeito.DANO),
    TEMPORAL(Efeito.DANO),
    TERREMOTO(Efeito.DANO),
    CHUVA_DE_LAVA(Efeito.MUITO_DANO),
    REGENERACAO_CONTINUA(Efeito.VIDA),
    CARREGAR_ENERGIA(Efeito.MUITA_MANA),
    VIDA_EM_PRESTACAO(Efeito.VIDA),
    SORTE_DIVINA(Efeito.MUITA_VIDA),
    BATERIA_FRACA(Efeito.MANA);

    private final Efeito efeito;

    Habilidade(Efeito efeito) {
        this.efeito = efeito;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public double getValorEfeito() {
        return efeito.getEfeito();
    }
}
