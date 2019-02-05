package com.sha.conditional;

import com.sha.model.Doctor;
import com.sha.model.Patient;
import com.sha.model.SpecialtyType;
import com.sha.model.TitleType;

public class ConditionalNestedClass {

    public static final double FIX_PRICE_VALUE = 100;
    public static final int MULTIPLY_PROF_FACTOR = 2;
    public static final int REPUTATION_SCORE_1 = 1000;
    public static final int REPUTATION_SCORE_2 = 500;
    public static final int MULTIPLY_PROF_REP_SCORE_1_FACTOR = 2;
    public static final double MULTIPLY_PROF_REP_SCORE_2_FACTOR = 1.5;
    public static final double MULTIPLY_ASSOC_FACTOR = 1.5;
    public static final int MULTIPLY_OTHER_FACTOR = 1;
    public static final double MULTIPLY_DR_SPECIALTY_FACTOR = 1.01;
    public static final int OPERATION_LEVEL_1 = 10;
    public static final int OPERATION_LEVEL_2 = 5;
    public static final double MULTIPLY_PATIENT_OPER_LEVEL_1_FACTOR = 0.90;
    public static final double MULTIPLY_PATIENT_OPER_LEVEL_2_FACTOR = 0.95;

    public double calculateFeeForDoctor(final Doctor doctor, final Patient patient) {
        double multiply = 0;
        if (doctor == null || patient == null) {
            return 0;
        }
        final TitleType title = doctor.getTitle();
        multiply = getTitleFactor(doctor, title);
        multiply = getSpecialtyFactor(doctor, multiply, title);
        multiply = getReputationFactor(multiply, patient.getOperationCount(), OPERATION_LEVEL_1, MULTIPLY_PATIENT_OPER_LEVEL_1_FACTOR, OPERATION_LEVEL_2, MULTIPLY_PATIENT_OPER_LEVEL_2_FACTOR);
        return FIX_PRICE_VALUE * multiply;
    }

    private double getSpecialtyFactor(Doctor doctor, double multiply, TitleType title) {
        for (final SpecialtyType specialty : doctor.getSpecialties()) {
            if (TitleType.DR.equals(title)) {
                multiply *= MULTIPLY_DR_SPECIALTY_FACTOR;
            }
        }
        return multiply;
    }

    private double getTitleFactor(Doctor doctor, TitleType title) {
        double multiply;
        if (TitleType.PROF.equals(title)) {
            multiply = MULTIPLY_PROF_FACTOR;
            multiply = getReputationFactor(multiply, doctor.getReputation(), REPUTATION_SCORE_1, MULTIPLY_PROF_REP_SCORE_1_FACTOR, REPUTATION_SCORE_2, MULTIPLY_PROF_REP_SCORE_2_FACTOR);
        } else if (TitleType.ASSOC.equals(title)) {
            multiply = MULTIPLY_ASSOC_FACTOR;
        } else {
            multiply = MULTIPLY_OTHER_FACTOR;
        }
        return multiply;
    }

    private double getReputationFactor(double multiply, int reputation, int reputationScore1, double multiplyProfRepScore1Factor, int reputationScore2, double multiplyProfRepScore2Factor) {
        if (reputation > reputationScore1) {
            multiply *= multiplyProfRepScore1Factor;
        } else if (reputation > reputationScore2) {
            multiply *= multiplyProfRepScore2Factor;
        }
        return multiply;
    }
}
