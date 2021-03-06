package hospital.hospital.blood.models;

import lombok.Data;

@Data
public class BloodBase {
    protected Float hematocrit;
    protected Float hemoglobin;
    protected Float leukocytes;
    protected Float basophils;
    protected Float eosinophils;
    protected Float neutrophils;
    protected Float lymphocytes;
    protected Float monocytes;
    protected Float erythrocytes;
    protected Float thrombocytes;
    protected Float redCellVolume;
    protected Float averageVolumeCell;
    protected Float averageHemoglobinContent;
    protected Float hemoglobinConcentration;
}
