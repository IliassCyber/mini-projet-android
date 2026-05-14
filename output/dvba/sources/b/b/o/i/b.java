package b.b.o.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import b.b.o.i.m;
import b.b.o.i.n;
import b.b.p.c.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f347c;
    public g d;
    public LayoutInflater e;
    public m.a f;
    public int g;
    public int h;
    public n i;

    public b(Context context, int i, int i2) {
        this.f346b = context;
        this.e = LayoutInflater.from(context);
        this.g = i;
        this.h = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar = view instanceof n.a ? (n.a) view : (n.a) this.e.inflate(this.h, viewGroup, false);
        b.b.p.c cVar = (b.b.p.c) this;
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) cVar.i);
        if (cVar.x == null) {
            cVar.x = cVar.new b();
        }
        actionMenuItemView.setPopupCallback(cVar.x);
        return (View) aVar;
    }

    @Override // b.b.o.i.m
    public boolean c(g gVar, i iVar) {
        return false;
    }

    @Override // b.b.o.i.m
    public void d(m.a aVar) {
        this.f = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.b.o.i.m
    public boolean f(r rVar) {
        m.a aVar = this.f;
        g gVar = rVar;
        if (aVar == null) {
            return false;
        }
        if (rVar == null) {
            gVar = this.d;
        }
        return aVar.c(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.o.i.m
    public void h(boolean z) {
        int i;
        boolean z2;
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.d;
        if (gVar != null) {
            gVar.i();
            ArrayList<i> arrayListL = this.d.l();
            int size = arrayListL.size();
            i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = arrayListL.get(i2);
                if (iVar.g()) {
                    View childAt = viewGroup.getChildAt(i);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View viewA = a(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        viewA.setPressed(false);
                        viewA.jumpDrawablesToCurrentState();
                    }
                    if (viewA != childAt) {
                        ViewGroup viewGroup2 = (ViewGroup) viewA.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(viewA);
                        }
                        ((ViewGroup) this.i).addView(viewA, i);
                    }
                    i++;
                }
            }
        } else {
            i = 0;
        }
        while (i < viewGroup.getChildCount()) {
            if (viewGroup.getChildAt(i) == ((b.b.p.c) this).j) {
                z2 = false;
            } else {
                viewGroup.removeViewAt(i);
                z2 = true;
            }
            if (!z2) {
                i++;
            }
        }
    }

    @Override // b.b.o.i.m
    public boolean k(g gVar, i iVar) {
        return false;
    }
}
