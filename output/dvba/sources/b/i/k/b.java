package b.i.k;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class b implements Spannable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f804c;
        public final int d;

        public a(PrecomputedText.Params params) {
            this.f802a = params.getTextPaint();
            this.f803b = params.getTextDirection();
            this.f804c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        @SuppressLint({"NewApi"})
        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f802a = textPaint;
            this.f803b = textDirectionHeuristic;
            this.f804c = i;
            this.d = i2;
        }

        public boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f804c != aVar.f804c || this.d != aVar.d)) || this.f802a.getTextSize() != aVar.f802a.getTextSize() || this.f802a.getTextScaleX() != aVar.f802a.getTextScaleX() || this.f802a.getTextSkewX() != aVar.f802a.getTextSkewX() || this.f802a.getLetterSpacing() != aVar.f802a.getLetterSpacing() || !TextUtils.equals(this.f802a.getFontFeatureSettings(), aVar.f802a.getFontFeatureSettings()) || this.f802a.getFlags() != aVar.f802a.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f802a.getTextLocales().equals(aVar.f802a.getTextLocales())) {
                    return false;
                }
            } else if (!this.f802a.getTextLocale().equals(aVar.f802a.getTextLocale())) {
                return false;
            }
            return this.f802a.getTypeface() == null ? aVar.f802a.getTypeface() == null : this.f802a.getTypeface().equals(aVar.f802a.getTypeface());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f803b == aVar.f803b;
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 24 ? Objects.hash(Float.valueOf(this.f802a.getTextSize()), Float.valueOf(this.f802a.getTextScaleX()), Float.valueOf(this.f802a.getTextSkewX()), Float.valueOf(this.f802a.getLetterSpacing()), Integer.valueOf(this.f802a.getFlags()), this.f802a.getTextLocales(), this.f802a.getTypeface(), Boolean.valueOf(this.f802a.isElegantTextHeight()), this.f803b, Integer.valueOf(this.f804c), Integer.valueOf(this.d)) : Objects.hash(Float.valueOf(this.f802a.getTextSize()), Float.valueOf(this.f802a.getTextScaleX()), Float.valueOf(this.f802a.getTextSkewX()), Float.valueOf(this.f802a.getLetterSpacing()), Integer.valueOf(this.f802a.getFlags()), this.f802a.getTextLocale(), this.f802a.getTypeface(), Boolean.valueOf(this.f802a.isElegantTextHeight()), this.f803b, Integer.valueOf(this.f804c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sbE;
            Object textLocale;
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sbE2 = c.a.a.a.a.e("textSize=");
            sbE2.append(this.f802a.getTextSize());
            sb.append(sbE2.toString());
            sb.append(", textScaleX=" + this.f802a.getTextScaleX());
            sb.append(", textSkewX=" + this.f802a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f802a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f802a.isElegantTextHeight());
            if (Build.VERSION.SDK_INT >= 24) {
                sbE = c.a.a.a.a.e(", textLocale=");
                textLocale = this.f802a.getTextLocales();
            } else {
                sbE = c.a.a.a.a.e(", textLocale=");
                textLocale = this.f802a.getTextLocale();
            }
            sbE.append(textLocale);
            sb.append(sbE.toString());
            StringBuilder sbE3 = c.a.a.a.a.e(", typeface=");
            sbE3.append(this.f802a.getTypeface());
            sb.append(sbE3.toString());
            if (Build.VERSION.SDK_INT >= 26) {
                StringBuilder sbE4 = c.a.a.a.a.e(", variationSettings=");
                sbE4.append(this.f802a.getFontVariationSettings());
                sb.append(sbE4.toString());
            }
            StringBuilder sbE5 = c.a.a.a.a.e(", textDir=");
            sbE5.append(this.f803b);
            sb.append(sbE5.toString());
            sb.append(", breakStrategy=" + this.f804c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        int i3 = Build.VERSION.SDK_INT;
        throw null;
    }

    @Override // java.lang.CharSequence
    public int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        int i = Build.VERSION.SDK_INT;
        throw null;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        int i4 = Build.VERSION.SDK_INT;
        throw null;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        throw null;
    }
}
