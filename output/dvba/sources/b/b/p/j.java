package b.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import b.b.p.n0;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f440b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static j f441c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f442a;

    public class a implements n0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f443a = {b.b.e.abc_textfield_search_default_mtrl_alpha, b.b.e.abc_textfield_default_mtrl_alpha, b.b.e.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f444b = {b.b.e.abc_ic_commit_search_api_mtrl_alpha, b.b.e.abc_seekbar_tick_mark_material, b.b.e.abc_ic_menu_share_mtrl_alpha, b.b.e.abc_ic_menu_copy_mtrl_am_alpha, b.b.e.abc_ic_menu_cut_mtrl_alpha, b.b.e.abc_ic_menu_selectall_mtrl_alpha, b.b.e.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f445c = {b.b.e.abc_textfield_activated_mtrl_alpha, b.b.e.abc_textfield_search_activated_mtrl_alpha, b.b.e.abc_cab_background_top_mtrl_alpha, b.b.e.abc_text_cursor_material, b.b.e.abc_text_select_handle_left_mtrl_dark, b.b.e.abc_text_select_handle_middle_mtrl_dark, b.b.e.abc_text_select_handle_right_mtrl_dark, b.b.e.abc_text_select_handle_left_mtrl_light, b.b.e.abc_text_select_handle_middle_mtrl_light, b.b.e.abc_text_select_handle_right_mtrl_light};
        public final int[] d = {b.b.e.abc_popup_background_mtrl_mult, b.b.e.abc_cab_background_internal_bg, b.b.e.abc_menu_hardkey_panel_mtrl_mult};
        public final int[] e = {b.b.e.abc_tab_indicator_material, b.b.e.abc_textfield_search_material};
        public final int[] f = {b.b.e.abc_btn_check_material, b.b.e.abc_btn_radio_material, b.b.e.abc_btn_check_material_anim, b.b.e.abc_btn_radio_material_anim};

        public final boolean a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList b(Context context, int i) {
            int iC = s0.c(context, b.b.a.colorControlHighlight);
            return new ColorStateList(new int[][]{s0.f485b, s0.d, s0.f486c, s0.f}, new int[]{s0.b(context, b.b.a.colorButtonNormal), b.i.f.a.a(iC, i), b.i.f.a.a(iC, i), i});
        }

        public ColorStateList c(Context context, int i) {
            if (i == b.b.e.abc_edit_text_material) {
                return b.b.l.a.a.a(context, b.b.c.abc_tint_edittext);
            }
            if (i == b.b.e.abc_switch_track_mtrl_alpha) {
                return b.b.l.a.a.a(context, b.b.c.abc_tint_switch_track);
            }
            if (i == b.b.e.abc_switch_thumb_material) {
                int[][] iArr = new int[3][];
                int[] iArr2 = new int[3];
                ColorStateList colorStateListD = s0.d(context, b.b.a.colorSwitchThumbNormal);
                if (colorStateListD == null || !colorStateListD.isStateful()) {
                    iArr[0] = s0.f485b;
                    iArr2[0] = s0.b(context, b.b.a.colorSwitchThumbNormal);
                    iArr[1] = s0.e;
                    iArr2[1] = s0.c(context, b.b.a.colorControlActivated);
                    iArr[2] = s0.f;
                    iArr2[2] = s0.c(context, b.b.a.colorSwitchThumbNormal);
                } else {
                    iArr[0] = s0.f485b;
                    iArr2[0] = colorStateListD.getColorForState(iArr[0], 0);
                    iArr[1] = s0.e;
                    iArr2[1] = s0.c(context, b.b.a.colorControlActivated);
                    iArr[2] = s0.f;
                    iArr2[2] = colorStateListD.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            }
            if (i == b.b.e.abc_btn_default_mtrl_shape) {
                return b(context, s0.c(context, b.b.a.colorButtonNormal));
            }
            if (i == b.b.e.abc_btn_borderless_material) {
                return b(context, 0);
            }
            if (i == b.b.e.abc_btn_colored_material) {
                return b(context, s0.c(context, b.b.a.colorAccent));
            }
            if (i == b.b.e.abc_spinner_mtrl_am_alpha || i == b.b.e.abc_spinner_textfield_background_material) {
                return b.b.l.a.a.a(context, b.b.c.abc_tint_spinner);
            }
            if (a(this.f444b, i)) {
                return s0.d(context, b.b.a.colorControlNormal);
            }
            if (a(this.e, i)) {
                return b.b.l.a.a.a(context, b.b.c.abc_tint_default);
            }
            if (a(this.f, i)) {
                return b.b.l.a.a.a(context, b.b.c.abc_tint_btn_checkable);
            }
            if (i == b.b.e.abc_seekbar_thumb_material) {
                return b.b.l.a.a.a(context, b.b.c.abc_tint_seek_thumb);
            }
            return null;
        }

        public final void d(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f440b;
            }
            drawable.setColorFilter(j.c(i, mode));
        }
    }

    public static synchronized j a() {
        if (f441c == null) {
            e();
        }
        return f441c;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        return n0.h(i, mode);
    }

    public static synchronized void e() {
        if (f441c == null) {
            j jVar = new j();
            f441c = jVar;
            jVar.f442a = n0.d();
            n0 n0Var = f441c.f442a;
            a aVar = new a();
            synchronized (n0Var) {
                n0Var.g = aVar;
            }
        }
    }

    public static void f(Drawable drawable, v0 v0Var, int[] iArr) {
        n0.l(drawable, v0Var, iArr);
    }

    public synchronized Drawable b(Context context, int i) {
        return this.f442a.f(context, i);
    }

    public synchronized ColorStateList d(Context context, int i) {
        return this.f442a.i(context, i);
    }
}
