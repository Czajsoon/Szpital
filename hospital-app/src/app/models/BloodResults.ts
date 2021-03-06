import {BloodResult} from "./BloodResult";

export interface BloodResults {
  date: Date | null;
  hematocrit: BloodResult | null;
  hemoglobin: BloodResult | null;
  leukocytes: BloodResult | null;
  BASO: BloodResult | null;
  eosinophils: BloodResult | null;
  neutrophils: BloodResult | null;
  lymphocytes: BloodResult | null;
  monocytes: BloodResult | null;
  erythrocytes: BloodResult | null;
  thrombocytes: BloodResult | null;
  RDW: BloodResult | null;
  MCV: BloodResult | null;
  MCH: BloodResult | null;
  MCHC: BloodResult | null;
}
