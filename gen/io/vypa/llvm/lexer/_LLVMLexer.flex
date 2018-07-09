package io.vypa.llvm.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static io.vypa.llvm.psi.LLVMTypes.*;

%%

%{
  public _LLVMLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _LLVMLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

KEYWORD=acq_rel|acquire|add|addrspace|addrspacecast|alias|align|alignstack|alloca|alwaysinline|and|any|anyregcc|appending|arcp|argmemonly|arm_aapcs_vfpcc|arm_aapcscc|arm_apcscc|ashr|asm|atomic|atomicrmw|available_externally|bitcast|blockaddress|br|builtin|byval|call|catch|catchpad|catchret|catchswitch|ccc|clause|cleanup|cleanuppad|cleanupret|cmpxchg|cold|coldcc|comdat|common|constant|convergent|cxx_fast_tlscc|datalayout|distinct|declare|default|define|deplibs|dereferenceable|dereferenceable_or_null|dllexport|dllimport|double|eq|exact|exactmatch|extern_weak|external|externally_initialized|extractelement|extractvalue|fadd|false|false|fast|fastcc|fcmp|fdiv|fence|filter|float|fmul|fp128|fpext|fpext|fptosi|fptoui|fptrunc|frem|from|fsub|gc|getelementptr|ghccc|global|half|hhvm_ccc|hhvmcc|hidden|icmp|inaccessiblemem_or_argmemonly|inaccessiblememonly|inalloca|inbounds|indirectbr|initialexec|inlinehint|inreg|insertelement|insertvalue|intel_ocl_bicc|inteldialect|internal|inttoptr|invoke|jumptable|landingpad|largest|linkonce|linkonce_odr|load|localdynamic|localexec|lshr|max|metadata|min|minsize|module|monotonic|msp430_intrcc|mul|musttail|naked|nand|ne|nest|ninf|nnan|noalias|noalias|nobuiltin|nocapture|noduplicate|noduplicates|noimplicitfloat|noinline|none|nonlazybind|nonnull|norecurse|noredzone|noreturn|notail|nounwind|nsw|nsz|null|nuw|oeq|oge|ogt|ole|olt|one|opaque|optnone|optsize|or|ord|personality|phippc_fp128|prefix|preserve_allcc|preserve_mostcc|private|prologue|protected|ptrtoint|ptrtoint|ptx_device|ptx_kernel|readnone|readonly|release|resume|ret|returned|returns_twice|safestack|samesize|sanitize_address|sanitize_memory|sanitize_thread|sdiv|section|select|seq_cst|sext|sge|sgt|shl|shufflevector|signext|signext|singlethread|sitofp|sitofp|sle|slt|spir_func|spir_kernel|srem|sret|ssp|sspreq|sspstrong|store|sub|switch|tail|target|thread_local|thunk|to|token|triple|true|true|trunc|trunc|type|udiv|ueq|uge|uge|ugt|ugt|uitofp|uitofp|ule|ult|umax|umin|undef|une|unnamed_addr|uno|unordered|unreachable|unwind|urem|uwtable|va_arg|void|volatile|weak|weak_odr|webkit_jscc|within|x86_64_sysvcc|x86_64_win64cc|x86_fastcallcc|x86_fp80|x86_intrcc|x86_mmx|x86_stdcallcc|x86_thiscallcc|x86_vectorcallcc|xchg|xor|xor|zeroext|zeroext|zeroinitializer|zext|zext
TYPE_LITERAL=i[0-9]+|half|float|double|fp128|x86_fp80|ppc_fp128|x86_mmx|opaque|void|token|label|metadata
DECIMAL_FPLITERAL=[-+]?[0-9]+[\.][0-9]*([eE][-+]?[0-9]+)?
HEX_FP80LITERAL=0xK[0-9A-Fa-f]+
HEX_FP128LITERAL=0xL[0-9A-Fa-f]+
HEX_PPC128LITERAL=0xM[0-9A-Fa-f]+
HEX_HALF_LITERAL=0xH[0-9A-Fa-f]+
HEX_FPLITERAL=0x[0-9A-Fa-f]+
INTERGER_LITERAL=[+-]?[0-9]+
LABEL_ID=[-a-zA-Z\$\._][-a-zA-Z\$\._0-9]*\:
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
CHAR_ARRAY_LITERAL=c{STRING}
COMMENT=;.*
LOCAL_IDENTIFIER=\%[-a-zA-Z\$._][-a-zA-Z\$._0-9]*|\%[0-9]+|\%{STRING}
GLOBAL_IDENTIFIER=\@[-a-zA-Z\$\._][-a-zA-Z._0-9]*|\@[0-9]+|\@{STRING}
COMDAT_IDENTIFIER=\$[a-zA-Z][-a-zA-Z0-9]*
METADATA_IDENTIFIER=\!([-a-zA-Z\$\._][-a-zA-Z\$._0-9]*|[0-9]+)
ATT_GROUP_ID=\#[0-9]+
LEFT_PARENTHESIS=\(
RIGHT_PARENTHESIS=\)
LEFT_BRACE=\{
RIGHT_BRACE=\}
LEFT_BRACKET=\[
RIGHT_BRACKET=\]
METADATA_STRING=\!{STRING}
OPERATOR=[\=]

%%
<YYINITIAL> {
  {WHITE_SPACE}                      { return WHITE_SPACE; }

  ","                                { return COMMA; }
  "*"                                { return ASTERISK; }
  "x"                                { return TIMES; }
  "!{"                               { return METADATA_LEFT_BRACE; }
  "align"                            { return ALIGN; }
  "addrspace"                        { return ADDRSPACE; }
  "unordered"                        { return UNORDERED; }
  "monotonic"                        { return MONOTONIC; }
  "acquire"                          { return ACQUIRE; }
  "release"                          { return RELEASE; }
  "acq_rel"                          { return ACQ_REL; }
  "seq_cst"                          { return SEQ_CST; }
  "catch"                            { return CATCH; }
  "filter"                           { return FILTER; }
  "asm"                              { return ASM; }
  "target"                           { return TARGET; }
  "triple"                           { return TRIPLE; }
  "datalayout"                       { return DATALAYOUT; }
  "deplibs"                          { return DEPLIBS; }
  "thread_local"                     { return THREAD_LOCAL; }
  "unnamed_addr"                     { return UNNAMED_ADDR; }
  "externally_initialized"           { return EXTERNALLY_INITIALIZED; }
  "alias"                            { return ALIAS; }
  "distinct"                         { return DISTINCT; }
  "attributes"                       { return ATTRIBUTES; }
  "alignstack"                       { return ALIGNSTACK; }
  "alwaysinline"                     { return ALWAYSINLINE; }
  "builtin"                          { return BUILTIN; }
  "cold"                             { return COLD; }
  "convergent"                       { return CONVERGENT; }
  "inaccessiblememonly"              { return INACCESSIBLEMEMONLY; }
  "inaccessiblemem_or_argmemonly"    { return INACCESSIBLEMEM_OR_ARGMEMONLY; }
  "inlinehint"                       { return INLINEHINT; }
  "jumptable"                        { return JUMPTABLE; }
  "minsize"                          { return MINSIZE; }
  "naked"                            { return NAKED; }
  "nobuiltin"                        { return NOBUILTIN; }
  "noduplicate"                      { return NODUPLICATE; }
  "noimplicitfloat"                  { return NOIMPLICITFLOAT; }
  "noinline"                         { return NOINLINE; }
  "nonlazybind"                      { return NONLAZYBIND; }
  "noredzone"                        { return NOREDZONE; }
  "noreturn"                         { return NORETURN; }
  "norecurse"                        { return NORECURSE; }
  "nounwind"                         { return NOUNWIND; }
  "optnone"                          { return OPTNONE; }
  "optsize"                          { return OPTSIZE; }
  "readnone"                         { return READNONE; }
  "readonly"                         { return READONLY; }
  "argmemonly"                       { return ARGMEMONLY; }
  "returns_twice"                    { return RETURNS_TWICE; }
  "ssp"                              { return SSP; }
  "sspreq"                           { return SSPREQ; }
  "sspstrong"                        { return SSPSTRONG; }
  "safestack"                        { return SAFESTACK; }
  "sanitize_address"                 { return SANITIZE_ADDRESS; }
  "sanitize_thread"                  { return SANITIZE_THREAD; }
  "sanitize_memory"                  { return SANITIZE_MEMORY; }
  "uwtable"                          { return UWTABLE; }
  "thunk"                            { return THUNK; }
  "declare"                          { return DECLARE; }
  "define"                           { return DEFINE; }
  "gc"                               { return GC; }
  "prefix"                           { return PREFIX; }
  "prologue"                         { return PROLOGUE; }
  "personality"                      { return PERSONALITY; }
  "global"                           { return GLOBAL; }
  "constant"                         { return CONSTANT; }
  "ret"                              { return RET; }
  "void"                             { return VOID; }
  "br"                               { return BR; }
  "switch"                           { return SWITCH; }
  "indirectbr"                       { return INDIRECTBR; }
  "invoke"                           { return INVOKE; }
  "to"                               { return TO; }
  "unwind"                           { return UNWIND; }
  "resume"                           { return RESUME; }
  "cleanupret"                       { return CLEANUPRET; }
  "from"                             { return FROM; }
  "caller"                           { return CALLER; }
  "catchret"                         { return CATCHRET; }
  "catchswitch"                      { return CATCHSWITCH; }
  "within"                           { return WITHIN; }
  "catchpad"                         { return CATCHPAD; }
  "cleanuppad"                       { return CLEANUPPAD; }
  "add"                              { return ADD; }
  "nuw"                              { return NUW; }
  "nsw"                              { return NSW; }
  "sub"                              { return SUB; }
  "mul"                              { return MUL; }
  "shl"                              { return SHL; }
  "fadd"                             { return FADD; }
  "fsub"                             { return FSUB; }
  "fmul"                             { return FMUL; }
  "fdiv"                             { return FDIV; }
  "frem"                             { return FREM; }
  "sdiv"                             { return SDIV; }
  "exact"                            { return EXACT; }
  "udiv"                             { return UDIV; }
  "lshr"                             { return LSHR; }
  "ashr"                             { return ASHR; }
  "urem"                             { return UREM; }
  "srem"                             { return SREM; }
  "and"                              { return AND; }
  "or"                               { return OR; }
  "xor"                              { return XOR; }
  "icmp"                             { return ICMP; }
  "fcmp"                             { return FCMP; }
  "trunc"                            { return TRUNC; }
  "zext"                             { return ZEXT; }
  "sext"                             { return SEXT; }
  "fptrunc"                          { return FPTRUNC; }
  "fpext"                            { return FPEXT; }
  "bitcast"                          { return BITCAST; }
  "addrspacecast"                    { return ADDRSPACECAST; }
  "uitofp"                           { return UITOFP; }
  "sitofp"                           { return SITOFP; }
  "fptoui"                           { return FPTOUI; }
  "fptosi"                           { return FPTOSI; }
  "inttoptr"                         { return INTTOPTR; }
  "ptrtoint"                         { return PTRTOINT; }
  "select"                           { return SELECT; }
  "va_arg"                           { return VA_ARG; }
  "extractelement"                   { return EXTRACTELEMENT; }
  "insertelement"                    { return INSERTELEMENT; }
  "shufflevector"                    { return SHUFFLEVECTOR; }
  "phi"                              { return PHI; }
  "landingpad"                       { return LANDINGPAD; }
  "cleanup"                          { return CLEANUP; }
  "tail"                             { return TAIL; }
  "musttail"                         { return MUSTTAIL; }
  "notail"                           { return NOTAIL; }
  "call"                             { return CALL; }
  "alloca"                           { return ALLOCA; }
  "inalloca"                         { return INALLOCA; }
  "load"                             { return LOAD; }
  "volatile"                         { return VOLATILE; }
  "atomic"                           { return ATOMIC; }
  "singlethread"                     { return SINGLETHREAD; }
  "store"                            { return STORE; }
  "cmpxchg"                          { return CMPXCHG; }
  "weak"                             { return WEAK; }
  "atomicrmw"                        { return ATOMICRMW; }
  "fence"                            { return FENCE; }
  "getelementptr"                    { return GETELEMENTPTR; }
  "inbounds"                         { return INBOUNDS; }
  "extractvalue"                     { return EXTRACTVALUE; }
  "insertvalue"                      { return INSERTVALUE; }
  "unreachable"                      { return UNREACHABLE; }
  "xchg"                             { return XCHG; }
  "nand"                             { return NAND; }
  "max"                              { return MAX; }
  "min"                              { return MIN; }
  "umax"                             { return UMAX; }
  "umin"                             { return UMIN; }
  "byval"                            { return BYVAL; }
  "dereferenceable"                  { return DEREFERENCEABLE; }
  "dereferenceable_or_null"          { return DEREFERENCEABLE_OR_NULL; }
  "inreg"                            { return INREG; }
  "nest"                             { return NEST; }
  "noalias"                          { return NOALIAS; }
  "nocapture"                        { return NOCAPTURE; }
  "nonnull"                          { return NONNULL; }
  "returned"                         { return RETURNED; }
  "signext"                          { return SIGNEXT; }
  "sret"                             { return SRET; }
  "zeroext"                          { return ZEROEXT; }
  "any"                              { return ANY; }
  "exactmatch"                       { return EXACTMATCH; }
  "largest"                          { return LARGEST; }
  "noduplicates"                     { return NODUPLICATES; }
  "samesize"                         { return SAMESIZE; }
  "true"                             { return TRUE; }
  "false"                            { return FALSE; }
  "null"                             { return NULL; }
  "undef"                            { return UNDEF; }
  "zeroinitializer"                  { return ZEROINITIALIZER; }
  "none"                             { return NONE; }
  "sideeffect"                       { return SIDEEFFECT; }
  "inteldialect"                     { return INTELDIALECT; }
  "blockaddress"                     { return BLOCKADDRESS; }
  "lshl"                             { return LSHL; }
  "ccc"                              { return CCC; }
  "fastcc"                           { return FASTCC; }
  "coldcc"                           { return COLDCC; }
  "x86_stdcallcc"                    { return X86_STDCALLCC; }
  "x86_fastcallcc"                   { return X86_FASTCALLCC; }
  "x86_thiscallcc"                   { return X86_THISCALLCC; }
  "x86_vectorcallcc"                 { return X86_VECTORCALLCC; }
  "arm_apcscc"                       { return ARM_APCSCC; }
  "arm_aapcscc"                      { return ARM_AAPCSCC; }
  "arm_aapcs_vfpcc"                  { return ARM_AAPCS_VFPCC; }
  "msp430_intrcc"                    { return MSP430_INTRCC; }
  "ptx_kernel"                       { return PTX_KERNEL; }
  "ptx_device"                       { return PTX_DEVICE; }
  "spir_kernel"                      { return SPIR_KERNEL; }
  "spir_func"                        { return SPIR_FUNC; }
  "intel_ocl_bicc"                   { return INTEL_OCL_BICC; }
  "x86_64_sysvcc"                    { return X86_64_SYSVCC; }
  "x86_64_win64cc"                   { return X86_64_WIN64CC; }
  "webkit_jscc"                      { return WEBKIT_JSCC; }
  "anyregcc"                         { return ANYREGCC; }
  "preserve_mostcc"                  { return PRESERVE_MOSTCC; }
  "preserve_allcc"                   { return PRESERVE_ALLCC; }
  "ghccc"                            { return GHCCC; }
  "x86_intrcc"                       { return X86_INTRCC; }
  "hhvmcc"                           { return HHVMCC; }
  "hhvm_ccc"                         { return HHVM_CCC; }
  "cxx_fast_tlscc"                   { return CXX_FAST_TLSCC; }
  "cc"                               { return CC; }
  "digit"                            { return DIGIT; }
  "private"                          { return PRIVATE; }
  "internal"                         { return INTERNAL; }
  "weak_odr"                         { return WEAK_ODR; }
  "linkonce"                         { return LINKONCE; }
  "linkonce_odr"                     { return LINKONCE_ODR; }
  "available_externally"             { return AVAILABLE_EXTERNALLY; }
  "appending"                        { return APPENDING; }
  "common"                           { return COMMON; }
  "extern_weak"                      { return EXTERN_WEAK; }
  "external"                         { return EXTERNAL; }
  "dllimport"                        { return DLLIMPORT; }
  "dllexport"                        { return DLLEXPORT; }
  "default"                          { return DEFAULT; }
  "hidden"                           { return HIDDEN; }
  "protected"                        { return PROTECTED; }
  "localdynamic"                     { return LOCALDYNAMIC; }
  "initialexec"                      { return INITIALEXEC; }
  "localexec"                        { return LOCALEXEC; }
  "oeq"                              { return OEQ; }
  "one"                              { return ONE; }
  "olt"                              { return OLT; }
  "ogt"                              { return OGT; }
  "ole"                              { return OLE; }
  "oge"                              { return OGE; }
  "ord"                              { return ORD; }
  "uno"                              { return UNO; }
  "ueq"                              { return UEQ; }
  "une"                              { return UNE; }
  "ult"                              { return ULT; }
  "ugt"                              { return UGT; }
  "ule"                              { return ULE; }
  "uge"                              { return UGE; }
  "eq"                               { return EQ; }
  "ne"                               { return NE; }
  "sgt"                              { return SGT; }
  "sge"                              { return SGE; }
  "slt"                              { return SLT; }
  "sle"                              { return SLE; }
  "fast"                             { return FAST; }
  "nnan"                             { return NNAN; }
  "ninf"                             { return NINF; }
  "nsz"                              { return NSZ; }
  "arcp"                             { return ARCP; }

  {KEYWORD}                          { return KEYWORD; }
  {TYPE_LITERAL}                     { return TYPE_LITERAL; }
  {DECIMAL_FPLITERAL}                { return DECIMAL_FPLITERAL; }
  {HEX_FP80LITERAL}                  { return HEX_FP80LITERAL; }
  {HEX_FP128LITERAL}                 { return HEX_FP128LITERAL; }
  {HEX_PPC128LITERAL}                { return HEX_PPC128LITERAL; }
  {HEX_HALF_LITERAL}                 { return HEX_HALF_LITERAL; }
  {HEX_FPLITERAL}                    { return HEX_FPLITERAL; }
  {INTERGER_LITERAL}                 { return INTERGER_LITERAL; }
  {LABEL_ID}                         { return LABEL_ID; }
  {STRING}                           { return STRING; }
  {CHAR_ARRAY_LITERAL}               { return CHAR_ARRAY_LITERAL; }
  {COMMENT}                          { return COMMENT; }
  {LOCAL_IDENTIFIER}                 { return LOCAL_IDENTIFIER; }
  {GLOBAL_IDENTIFIER}                { return GLOBAL_IDENTIFIER; }
  {COMDAT_IDENTIFIER}                { return COMDAT_IDENTIFIER; }
  {METADATA_IDENTIFIER}              { return METADATA_IDENTIFIER; }
  {ATT_GROUP_ID}                     { return ATT_GROUP_ID; }
  {LEFT_PARENTHESIS}                 { return LEFT_PARENTHESIS; }
  {RIGHT_PARENTHESIS}                { return RIGHT_PARENTHESIS; }
  {LEFT_BRACE}                       { return LEFT_BRACE; }
  {RIGHT_BRACE}                      { return RIGHT_BRACE; }
  {LEFT_BRACKET}                     { return LEFT_BRACKET; }
  {RIGHT_BRACKET}                    { return RIGHT_BRACKET; }
  {METADATA_STRING}                  { return METADATA_STRING; }
  {OPERATOR}                         { return OPERATOR; }

}

[^] { return BAD_CHARACTER; }
