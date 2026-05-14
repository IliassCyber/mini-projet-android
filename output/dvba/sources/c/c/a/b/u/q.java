package c.c.a.b.u;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.u.f;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f1712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f1713c;

    public q(r rVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f1713c = rVar;
        this.f1712b = materialCalendarGridView;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        p adapter = this.f1712b.getAdapter();
        if (i >= adapter.a() && i <= adapter.c()) {
            f.InterfaceC0065f interfaceC0065f = this.f1713c.e;
            long jLongValue = this.f1712b.getAdapter().getItem(i).longValue();
            f.d dVar = (f.d) interfaceC0065f;
            if (f.this.Z.e.g(jLongValue)) {
                f.this.Y.b(jLongValue);
                Iterator it = f.this.W.iterator();
                while (it.hasNext()) {
                    ((s) it.next()).a(f.this.Y.a());
                }
                f.this.e0.getAdapter().f189a.b();
                RecyclerView recyclerView = f.this.d0;
                if (recyclerView != null) {
                    recyclerView.getAdapter().f189a.b();
                }
            }
        }
    }
}
