package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* JADX INFO: loaded from: classes.dex */
public final class Field implements SafeParcelable {
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    private final String mName;
    private final int zzCY;
    private final int zzakB;
    public static final Field FIELD_ACTIVITY = zzcH("activity");
    public static final Field FIELD_CONFIDENCE = zzcI("confidence");
    public static final Field zzakv = zzcK("activity_confidences");
    public static final Field FIELD_STEPS = zzcH("steps");
    public static final Field FIELD_DURATION = zzcH("duration");
    public static final Field FIELD_BPM = zzcI("bpm");
    public static final Field FIELD_LATITUDE = zzcI("latitude");
    public static final Field FIELD_LONGITUDE = zzcI("longitude");
    public static final Field FIELD_ACCURACY = zzcI("accuracy");
    public static final Field FIELD_ALTITUDE = zzcI("altitude");
    public static final Field zzakw = zzcI("elevation.gain");
    public static final Field FIELD_DISTANCE = zzcI("distance");
    public static final Field FIELD_HEIGHT = zzcI("height");
    public static final Field FIELD_WEIGHT = zzcI("weight");
    public static final Field FIELD_CIRCUMFERENCE = zzcI("circumference");
    public static final Field FIELD_PERCENTAGE = zzcI("percentage");
    public static final Field FIELD_SPEED = zzcI("speed");
    public static final Field FIELD_RPM = zzcI("rpm");
    public static final Field FIELD_REVOLUTIONS = zzcH("revolutions");
    public static final String NUTRIENT_CALORIES = "calories";
    public static final Field FIELD_CALORIES = zzcI(NUTRIENT_CALORIES);
    public static final Field FIELD_WATTS = zzcI("watts");
    public static final Field FIELD_MEAL_TYPE = zzcH("meal_type");
    public static final Field FIELD_FOOD_ITEM = zzcJ("food_item");
    public static final Field FIELD_NUTRIENTS = zzcK("nutrients");
    public static final Field FIELD_EXERCISE = zzcJ("exercise");
    public static final Field FIELD_REPETITIONS = zzcH("repetitions");
    public static final Field FIELD_RESISTANCE = zzcI("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzcH("resistance_type");
    public static final Field FIELD_NUM_SEGMENTS = zzcH("num_segments");
    public static final Field FIELD_AVERAGE = zzcI("average");
    public static final Field FIELD_MAX = zzcI("max");
    public static final Field FIELD_MIN = zzcI("min");
    public static final Field FIELD_LOW_LATITUDE = zzcI("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zzcI("low_longitude");
    public static final Field FIELD_HIGH_LATITUDE = zzcI("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zzcI("high_longitude");
    public static final Field zzakx = zzcH("edge_type");
    public static final Field zzaky = zzcI("x");
    public static final Field zzakz = zzcI("y");
    public static final Field zzakA = zzcI("z");
    public static final Parcelable.Creator<Field> CREATOR = new zzi();

    Field(int i, String str, int i2) {
        this.zzCY = i;
        this.mName = (String) zzu.zzu(str);
        this.zzakB = i2;
    }

    private Field(String str, int i) {
        this(1, str, i);
    }

    private boolean zza(Field field) {
        return this.mName.equals(field.mName) && this.zzakB == field.zzakB;
    }

    private static Field zzcH(String str) {
        return new Field(str, 1);
    }

    private static Field zzcI(String str) {
        return new Field(str, 2);
    }

    private static Field zzcJ(String str) {
        return new Field(str, 3);
    }

    private static Field zzcK(String str) {
        return new Field(str, 4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.fitness.data.Field zzn(java.lang.String r1, int r2) {
        /*
            Method dump skipped, instruction units count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.Field.zzn(java.lang.String, int):com.google.android.gms.fitness.data.Field");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Field) && zza((Field) obj));
    }

    public int getFormat() {
        return this.zzakB;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.mName;
        objArr[1] = this.zzakB == 1 ? "i" : "f";
        return String.format("%s(%s)", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
