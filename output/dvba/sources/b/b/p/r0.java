package b.b.p;

import android.R;
import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class r0 extends b.j.a.c implements View.OnClickListener {
    public final SearchView m;
    public final SearchableInfo n;
    public final Context o;
    public final WeakHashMap<String, Drawable.ConstantState> p;
    public final int q;
    public boolean r;
    public int s;
    public ColorStateList t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f482c;
        public final ImageView d;
        public final ImageView e;

        public a(View view) {
            this.f480a = (TextView) view.findViewById(R.id.text1);
            this.f481b = (TextView) view.findViewById(R.id.text2);
            this.f482c = (ImageView) view.findViewById(R.id.icon1);
            this.d = (ImageView) view.findViewById(R.id.icon2);
            this.e = (ImageView) view.findViewById(b.b.f.edit_query);
        }
    }

    public r0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.r = false;
        this.s = 1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    public static String e(Cursor cursor, String str) {
        return i(cursor, cursor.getColumnIndex(str));
    }

    public static String i(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    @Override // b.j.a.a
    public void a(View view, Context context, Cursor cursor) throws FileNotFoundException {
        Drawable drawableG;
        String string;
        Drawable drawable;
        ActivityInfo activityInfo;
        int iconResource;
        CharSequence charSequenceI;
        a aVar = (a) view.getTag();
        int i = this.z;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f480a != null) {
            String strI = i(cursor, this.u);
            TextView textView = aVar.f480a;
            textView.setText(strI);
            textView.setVisibility(TextUtils.isEmpty(strI) ? 8 : 0);
        }
        if (aVar.f481b != null) {
            String strI2 = i(cursor, this.w);
            if (strI2 != null) {
                if (this.t == null) {
                    TypedValue typedValue = new TypedValue();
                    this.e.getTheme().resolveAttribute(b.b.a.textColorSearchUrl, typedValue, true);
                    this.t = this.e.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(strI2);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, strI2.length(), 33);
                charSequenceI = spannableString;
            } else {
                charSequenceI = i(cursor, this.v);
            }
            if (TextUtils.isEmpty(charSequenceI)) {
                TextView textView2 = aVar.f480a;
                if (textView2 != null) {
                    textView2.setSingleLine(false);
                    aVar.f480a.setMaxLines(2);
                }
            } else {
                TextView textView3 = aVar.f480a;
                if (textView3 != null) {
                    textView3.setSingleLine(true);
                    aVar.f480a.setMaxLines(1);
                }
            }
            TextView textView4 = aVar.f481b;
            textView4.setText(charSequenceI);
            textView4.setVisibility(TextUtils.isEmpty(charSequenceI) ? 8 : 0);
        }
        ImageView imageView = aVar.f482c;
        if (imageView != null) {
            int i3 = this.x;
            if (i3 == -1) {
                drawableG = null;
            } else {
                drawableG = g(cursor.getString(i3));
                if (drawableG == null) {
                    ComponentName searchActivity = this.n.getSearchActivity();
                    String strFlattenToShortString = searchActivity.flattenToShortString();
                    if (this.p.containsKey(strFlattenToShortString)) {
                        Drawable.ConstantState constantState = this.p.get(strFlattenToShortString);
                        drawableG = constantState == null ? null : constantState.newDrawable(this.o.getResources());
                    } else {
                        PackageManager packageManager = this.e.getPackageManager();
                        try {
                            activityInfo = packageManager.getActivityInfo(searchActivity, 128);
                            iconResource = activityInfo.getIconResource();
                        } catch (PackageManager.NameNotFoundException e) {
                            string = e.toString();
                        }
                        if (iconResource != 0) {
                            drawable = packageManager.getDrawable(searchActivity.getPackageName(), iconResource, activityInfo.applicationInfo);
                            if (drawable == null) {
                                string = "Invalid icon resource " + iconResource + " for " + searchActivity.flattenToShortString();
                                Log.w("SuggestionsAdapter", string);
                                drawable = null;
                            }
                        } else {
                            drawable = null;
                        }
                        this.p.put(strFlattenToShortString, drawable == null ? null : drawable.getConstantState());
                        drawableG = drawable;
                    }
                    if (drawableG == null) {
                        drawableG = this.e.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            imageView.setImageDrawable(drawableG);
            if (drawableG == null) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
                drawableG.setVisible(false, false);
                drawableG.setVisible(true, false);
            }
        }
        ImageView imageView2 = aVar.d;
        if (imageView2 != null) {
            int i4 = this.y;
            Drawable drawableG2 = i4 != -1 ? g(cursor.getString(i4)) : null;
            imageView2.setImageDrawable(drawableG2);
            if (drawableG2 == null) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setVisibility(0);
                drawableG2.setVisible(false, false);
                drawableG2.setVisible(true, false);
            }
        }
        int i5 = this.s;
        if (i5 != 2 && (i5 != 1 || (i2 & 1) == 0)) {
            aVar.e.setVisibility(8);
            return;
        }
        aVar.e.setVisibility(0);
        aVar.e.setTag(aVar.f480a.getText());
        aVar.e.setOnClickListener(this);
    }

    @Override // b.j.a.a
    public void b(Cursor cursor) {
        if (this.r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // b.j.a.a
    public CharSequence c(Cursor cursor) {
        String strI;
        String strI2;
        if (cursor == null) {
            return null;
        }
        String strI3 = i(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (strI3 != null) {
            return strI3;
        }
        if (this.n.shouldRewriteQueryFromData() && (strI2 = i(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return strI2;
        }
        if (!this.n.shouldRewriteQueryFromText() || (strI = i(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return strI;
    }

    @Override // b.j.a.c, b.j.a.a
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.l.inflate(this.j, viewGroup, false);
        viewInflate.setTag(new a(viewInflate));
        ((ImageView) viewInflate.findViewById(b.b.f.edit_query)).setImageResource(this.q);
        return viewInflate;
    }

    public Drawable f(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.e.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(java.lang.String r8) throws java.io.FileNotFoundException {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.p.r0.g(java.lang.String):android.graphics.drawable.Drawable");
    }

    @Override // b.j.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewInflate = this.l.inflate(this.k, viewGroup, false);
            if (viewInflate != null) {
                ((a) viewInflate.getTag()).f480a.setText(e.toString());
            }
            return viewInflate;
        }
    }

    @Override // b.j.a.a, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewD = d(this.e, this.d, viewGroup);
            ((a) viewD.getTag()).f480a.setText(e.toString());
            return viewD;
        }
    }

    public Cursor h(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.e.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final void j(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        j(this.d);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        j(this.d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.z((CharSequence) tag);
        }
    }
}
