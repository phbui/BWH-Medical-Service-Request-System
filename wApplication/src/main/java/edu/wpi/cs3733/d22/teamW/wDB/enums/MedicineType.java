package edu.wpi.cs3733.d22.teamW.wDB.enums;

import edu.wpi.cs3733.d22.teamW.wDB.Errors.NoMedicine;
import java.util.HashMap;
import java.util.Map;

public enum MedicineType {
  Adderall("Adderall"),
  Abacavir("Abacavir"),
  Acyclovir("Acyclovir"),
  Alemtuzumab("Alemtuzumab"),
  Alendronate("Alendronate"),
  Allopurinol("Allopurinol"),
  Amifostine("Amifostine"),
  Amikacin("Amikacin"),
  AminocaproicAcid("AminocaproicAcid"),
  Amitriptyline("Amitriptyline"),
  Amlodipine("Amlodipine"),
  Amoxicillin("Amoxicillin"),
  AmoxicillinClavulanicAcid("Amoxicillin / Clavulanic Acid"),
  AmphotericinB("AmphotericinB"),
  Ampicillin("Ampicillin"),
  AntiInhibitorCoagulantComplexFEIBA("AntiInhibitor Coagulant Complex (FEIBA)"),
  AntithymocyteGlobulin("Anti-thymocyte Globulin"),
  Aprepitant("Aprepitant"),
  Asparagomase("Asparagomase"),
  Atazanavir("Atazanavir"),
  Atenolol("Atenolol"),
  Atovaquone("Atovaquone"),
  Azithromycin("Azithromycin"),
  Baclofen("Baclofen"),
  Bleomycin("Bleomycin"),
  Bortezomib("Bortezomib"),
  Bosentan("Bosentan"),
  Busulfan("Busulfan"),
  Calcium("Calcium"),
  Captopril("Captopril"),
  Carbamazepine("Carbamazepine"),
  Carboplatin("Carboplatin"),
  Carmustine("Carmustine"),
  Cefaclor("Cefaclor"),
  Cefepime("Cefepime"),
  Cefixime("Cefixime"),
  Ceftazidime("Ceftazidime"),
  Cefuroxime("Cefuroxime"),
  Celecoxib("Celecoxib"),
  Cephalexin("Cephalexin"),
  Cidofovir("Cidofovir"),
  Cisplatin("Cisplatin"),
  Cladribine("Cladribine"),
  Clarithromycin("Clarithromycin"),
  Clindamycin("Clindamycin"),
  Clobazam("Clobazam"),
  Clofarabine("Clofarabine"),
  Codeine("Codeine"),
  Crizanlizumab("Crizanlizumab"),
  Crizotinib("Crizotinib"),
  Cyclobenzaprine("Cyclobenzaprine"),
  Cyclophosphamide("Cyclophosphamide"),
  Cyclosporine("Cyclosporine"),
  Cyproheptadine("Cyproheptadine"),
  Cytarabine("Cytarabine"),
  Dacarbazine("Dacarbazine"),
  Dactinomycin("Dactinomycin"),
  Dapsone("Dapsone"),
  DarunavirPrezista("Darunavir (Prezista®)"),
  Dasatinib("Dasatinib"),
  Daunorubicin("Daunorubicin"),
  DeferasiroxExjade("Deferasirox (Exjade®)"),
  DesmopressinStimate("Desmopressin (Stimate®)"),
  Dexamethasone("Dexamethasone"),
  Diclofenac("Diclofenac"),
  Didanosine("Didanosine"),
  Dinutuximab("Dinutuximab"),
  Dobutamine("Dobutamine"),
  Dopamine("Dopamine"),
  DornaseAlfa("Dornase alfa"),
  Doxorubicin("Doxorubicin"),
  Dronabinol("Dronabinol"),
  Efavirenz("Efavirenz"),
  EfavirenzEmtricitabineTenofovirAtripla("Efavirenz / emtricitabine / tenofovir (Atripla®)"),
  Eltrombopag("Eltrombopag"),
  ElvitegravirCobicistatEmtricitabineTenofovirStribild(
      "Elvitegravir / cobicistat / emtricitabine / tenofovir (Stribild®)"),
  ElvitegravirCobicistatEmtricitabineTenofovirAlafenamideGenvoya(
      "Elvitegravir / cobicistat / emtricitabine / tenofovir alafenamide (Genvoya®)"),
  Emicizumab("Emicizumab"),
  EmtricitabineEmtriva("Emtricitabine (Emtriva®)"),
  EmtricitabineRilpivirineTenofovirAlafenamideOdefsey(
      "Emtricitabine / rilpivirine / tenofovir alafenamide (Odefsey®)"),
  EmtricitabineTenofovirTruvada("Emtricitabine / tenofovir (Truvada®)"),
  EmtricitabineTenofovirAlafenamideDescovy("Emtricitabine / tenofovir alafenamide (Descovy®)"),
  Enalapril("Enalapril"),
  Enoxaparin("Enoxaparin"),
  Erlotinib("Erlotinib"),
  Erythromycin("Erythromycin"),
  Erythropoietin("Erythropoietin"),
  EtonogestrelNexplanon("Etonogestrel (Nexplanon®)"),
  Etoposide("Etoposide"),
  EtravirineIntelence("Etravirine (Intelence®)"),
  FactorIXComplex("Factor IX Complex"),
  FactorIXConcentrate("Factor IX Concentrate"),
  FactorVIIaRecombinant("Factor VIIa (Recombinant)"),
  FactorVIIIHumanAndVonWillebrandFactor("Factor VIII (Human) and von Willebrand Factor"),
  FactorVIIIRecombinant("Factor VIII (Recombinant)"),
  Famciclovir("Famciclovir"),
  Famotidine("Famotidine"),
  Fidaxomicin("Fidaxomicin"),
  Fluconazole("Fluconazole"),
  Fludarabine("Fludarabine"),
  Fluorouracil("Fluorouracil"),
  Foscarnet("Foscarnet"),
  Furosemide("Furosemide"),
  GCSFFilgrastim("G-CSF (Filgrastim)"),
  Gabapentin("Gabapentin"),
  Ganciclovir("Ganciclovir"),
  Gefitinib("Gefitinib"),
  Gemcitabine("Gemcitabine"),
  GemtuzumabOzogamicin("Gemtuzumab Ozogamicin"),
  GMCSFSargramostim("GM-CSF (Sargramostim)"),
  Granisetron("Granisetron"),
  HeparinLockFlushForChildrenAndYoungAdults("Heparin Lock Flush for children and young adults"),
  HeparinLockFlushForInfants("Heparin Lock Flush for infants"),
  Hydralazine("Hydralazine"),
  HydrocodoneWithAcetaminophen("Hydrocodone with acetaminophen"),
  Hydrocortisone("Hydrocortisone"),
  Hydromorphone("Hydromorphone"),
  Hydroxyurea("Hydroxyurea"),
  HydroxyureaForSickleCellDisease("Hydroxyurea For Sickle Cell Disease"),
  Ifosfamide("Ifosfamide"),
  Imatinib("Imatinib"),
  ImipenemCilastatin("Imipenem Cilastatin"),
  ImmuneGlobulin("Immune Globulin"),
  InterferonAlfa2aAndAlfa2b("Interferon alfa-2a and alfa-2b"),
  InterferonAlfa2bForMelanoma("Interferon alfa-2b for melanoma"),
  Interleukin2Aldesleukin("Interleukin-2 (Aldesleukin)"),
  Irinotecan("Irinotecan"),
  Isotretinoin("Isotretinoin"),
  Itraconazole("Itraconazole"),
  Ketoconazole("Ketoconazole"),
  LGlutamine("LGlutamine"),
  Labetalol("Labetalol"),
  Lamivudine("Lamivudine"),
  LeucovorinWithHighDoseMethotrexateHDMTX("Leucovorin with high dose methotrexate (HDMTX)"),
  Levothyroxine("Levothyroxine"),
  Linezolid("Linezolid"),
  Lomustine("Lomustine"),
  LopinavirRitonavirKaletra("Lopinavir / Ritonavir (Kaletra®)"),
  Lorazepam("Lorazepam"),
  Lorlatinib("Lorlatinib"),
  Magnesium("Magnesium"),
  MaravirocSelzentry("Maraviroc Selzentry"),
  Mechlorethamine("Mechlorethamine"),
  MegestrolAcetate("Megestrol Acetate"),
  Meloxicam("Meloxicam"),
  Melphalan("Melphalan"),
  Meperidine("Meperidine"),
  Mercaptopurine("Mercaptopurine"),
  Meropenem("Meropenem"),
  Mesna("Mesna"),
  Methadone("Methadone"),
  Methotrexate("Methotrexate"),
  Methylphenidate("Methylphenidate"),
  Metronidazole("Metronidazole"),
  Micafungin("Micafungin"),
  Mitotane("Mitotane"),
  Mitoxantrone("Mitoxantrone"),
  Modafinil("Modafinil"),
  Morphine("Morphine"),
  MuromonabCD3("Muromonab - CD3"),
  MycophenolateMofetil("Mycophenolate Mofetil"),
  Nelarabine("Nelarabine"),
  Nelfinavir("Nelfinavir"),
  NeuromuscularBlockers("Neuromuscular Blockers"),
  Nevirapine("Nevirapine"),
  Norepinephrine("Norepinephrine"),
  Omeprazole("Omeprazole"),
  Ondansetron("Ondansetron"),
  Oxycodone("Oxycodone"),
  Paclitaxel("Paclitaxel"),
  PEGaspargase("PEGaspargase"),
  Pegfilgrastim("Pegfilgrastim"),
  Pemetrexed("Pemetrexed"),
  PenicillinVK("PenicillinVK"),
  PentamidineInhaledByMouth("Pentamidine Inhaled By Mouth"),
  Phenobarbital("Phenobarbital"),
  Phenytoin("Phenytoin"),
  Phosphorus("Phosphorus"),
  Posaconazole("Posaconazole"),
  Potassium("Potassium"),
  Prednisone("Prednisone"),
  Probenecid("Probenecid"),
  Procarbazine("Procarbazine"),
  Promethazine("Promethazine"),
  PromethazineTopicalGel("Promethazine Topical Gel"),
  Propoxyphene("Propoxyphene"),
  RaltegravirIsentress("Raltegravir (Isentress®)"),
  Ranitidine("Ranitidine"),
  Rasburicase("Rasburicase"),
  Regorafenib("Regorafenib"),
  RilpivirineEdurant("Rilpivirine (Edurant®)"),
  RilpivirineEmtricitabineTenofovirComplera("Rilpivirine / emtricitabine / tenofovir (Complera®)"),
  Ritonavir("Ritonavir"),
  Rituximab("Rituximab"),
  Rivaroxaban("Rivaroxaban"),
  Ruxolitinib("Ruxolitinib"),
  SacubitrilValsartanEntresto("Sacubitril/valsartan (Entresto®)"),
  Saquinavir("Saquinavir"),
  Sirolimus("Sirolimus"),
  Sorafenib("Sorafenib"),
  Stavudine("Stavudine"),
  Sucralfate("Sucralfate"),
  Sugammadex("Sugammadex"),
  Sunitinib("Sunitinib"),
  Tacrolimus("Tacrolimus"),
  Temozolomide("Temozolomide"),
  Teniposide("Teniposide"),
  Tenofovir("Tenofovir"),
  Thioguanine("Thioguanine"),
  Thiotepa("Thiotepa"),
  Tobramycin("Tobramycin"),
  Topotecan("Topotecan"),
  TretinoinOintment("TretinoinOintment"),
  TretinoinPill("TretinoinPill"),
  TrimethoprimSulfamethoxazole("Trimethoprim / Sulfamethoxazole"),
  ValproicAcid("ValproicAcid"),
  Vancomycin("Vancomycin"),
  Vinblastine("Vinblastine"),
  Vincristine("Vincristine"),
  Voriconazole("Voriconazole"),
  Vorinostat("Vorinostat"),
  Voxelotor("Voxelotor"),
  Warfarin("Warfarin"),
  Zidovudine("Zidovudine"),
  ZidovudineLamivudineCombivir("Zidovudine / Lamivudine (Combivir®)");

  private final String string;

  private static Map map = new HashMap<>();

  private MedicineType(String name) {
    this.string = name;
  }

  static {
    for (MedicineType medicineType : MedicineType.values()) {
      map.put(medicineType.string, medicineType);
    }
  }

  public String getString() {
    return this.string;
  }

  public static MedicineType getMedicine(String medicine) throws NoMedicine {
    MedicineType type = null;
    type = (MedicineType) map.get(medicine);
    if (type == null) {
      throw new NoMedicine();
    }
    return type;
  }
}
