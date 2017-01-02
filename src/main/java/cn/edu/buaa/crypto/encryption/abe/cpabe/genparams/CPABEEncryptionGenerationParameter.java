package cn.edu.buaa.crypto.encryption.abe.cpabe.genparams;

import cn.edu.buaa.crypto.access.AccessControlEngine;
import cn.edu.buaa.crypto.algebra.genparams.PairingEncryptionGenerationParameter;
import cn.edu.buaa.crypto.algebra.serparams.PairingCipherSerParameter;
import cn.edu.buaa.crypto.algebra.serparams.PairingKeySerParameter;
import cn.edu.buaa.crypto.chameleonhash.ChameleonHasher;
import it.unisa.dia.gas.jpbc.Element;

/**
 * Created by Weiran Liu on 2016/11/19.
 *
 * CP-ABE ciphertext generation parameter.
 */
public class CPABEEncryptionGenerationParameter extends PairingEncryptionGenerationParameter {
    private AccessControlEngine accessControlEngine;
    private int[][] accessPolicy;
    private String[] rhos;
    private ChameleonHasher chameleonHasher;
    private PairingCipherSerParameter intermediate;

    public CPABEEncryptionGenerationParameter(AccessControlEngine accessControlEngine, PairingKeySerParameter publicKeyParameter,
                                              int[][] accessPolicy, String[] rhos, Element message) {
        super(publicKeyParameter, message);
        this.accessControlEngine = accessControlEngine;
        this.accessPolicy = accessPolicy;
        this.rhos = rhos;
    }

    public void setIntermediate(PairingCipherSerParameter intermediate) {
        this.intermediate = intermediate;
    }

    public void setChameleonHasher(ChameleonHasher chameleonHasher) {
        this.chameleonHasher = chameleonHasher;
    }

    public AccessControlEngine getAccessControlEngine() {
        return this.accessControlEngine;
    }

    public int[][] getAccessPolicy() { return this.accessPolicy; }

    public String[] getRhos() { return this.rhos; }

    public ChameleonHasher getChameleonHasher() {
        return this.chameleonHasher;
    }

    public boolean isIntermediateGeneration() {
        return (this.intermediate != null);
    }

    public PairingCipherSerParameter getIntermediate() {
        return this.intermediate;
    }
}
