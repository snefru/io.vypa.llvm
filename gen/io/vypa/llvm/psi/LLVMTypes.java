// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.vypa.llvm.psi.impl.*;

public interface LLVMTypes {

  IElementType ADDRESS_SPACE = new LLVMElementType("ADDRESS_SPACE");
  IElementType ADDRESS_SPACE_TYPE = new LLVMElementType("ADDRESS_SPACE_TYPE");
  IElementType ALIGNMENT = new LLVMElementType("ALIGNMENT");
  IElementType ARGUMENT = new LLVMElementType("ARGUMENT");
  IElementType ARGUMENT_LIST = new LLVMElementType("ARGUMENT_LIST");
  IElementType ARRAY_TYPE = new LLVMElementType("ARRAY_TYPE");
  IElementType ATOMIC_ORDERING = new LLVMElementType("ATOMIC_ORDERING");
  IElementType BASIC_BLOCK = new LLVMElementType("BASIC_BLOCK");
  IElementType CALLING_CONVENTION = new LLVMElementType("CALLING_CONVENTION");
  IElementType CLAUSE = new LLVMElementType("CLAUSE");
  IElementType COMDAT = new LLVMElementType("COMDAT");
  IElementType DLL_STORAGE_CLASS = new LLVMElementType("DLL_STORAGE_CLASS");
  IElementType ENTITY = new LLVMElementType("ENTITY");
  IElementType FAST_MATHS_FLAG = new LLVMElementType("FAST_MATHS_FLAG");
  IElementType FLOAT_LITERAL = new LLVMElementType("FLOAT_LITERAL");
  IElementType FP_PREDICATE = new LLVMElementType("FP_PREDICATE");
  IElementType FUNCTION_ATTRIBUTE = new LLVMElementType("FUNCTION_ATTRIBUTE");
  IElementType FUNCTION_BODY = new LLVMElementType("FUNCTION_BODY");
  IElementType FUNCTION_DECLARATION = new LLVMElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_DEFINITION = new LLVMElementType("FUNCTION_DEFINITION");
  IElementType FUNCTION_HEADER = new LLVMElementType("FUNCTION_HEADER");
  IElementType FUNCTION_TYPE = new LLVMElementType("FUNCTION_TYPE");
  IElementType INDEX = new LLVMElementType("INDEX");
  IElementType INSTRUCTION = new LLVMElementType("INSTRUCTION");
  IElementType INT_PREDICATE = new LLVMElementType("INT_PREDICATE");
  IElementType LINKAGE = new LLVMElementType("LINKAGE");
  IElementType METADATA = new LLVMElementType("METADATA");
  IElementType OPERAND_BUNDLE = new LLVMElementType("OPERAND_BUNDLE");
  IElementType OPERATION = new LLVMElementType("OPERATION");
  IElementType PACKED_STRUCTURE_TYPE = new LLVMElementType("PACKED_STRUCTURE_TYPE");
  IElementType PARAMETER = new LLVMElementType("PARAMETER");
  IElementType PARAMETER_ATTRIBUTE = new LLVMElementType("PARAMETER_ATTRIBUTE");
  IElementType PARAMETER_LIST = new LLVMElementType("PARAMETER_LIST");
  IElementType POINTER_TYPE = new LLVMElementType("POINTER_TYPE");
  IElementType PRIMITIVE_TYPE = new LLVMElementType("PRIMITIVE_TYPE");
  IElementType RETURN_ATTRIBUTE = new LLVMElementType("RETURN_ATTRIBUTE");
  IElementType SCOPE = new LLVMElementType("SCOPE");
  IElementType SECTION = new LLVMElementType("SECTION");
  IElementType SELECTION_KIND = new LLVMElementType("SELECTION_KIND");
  IElementType STATEMENT = new LLVMElementType("STATEMENT");
  IElementType STRUCTURE_TYPE = new LLVMElementType("STRUCTURE_TYPE");
  IElementType THREAD_LOCAL_STORAGE = new LLVMElementType("THREAD_LOCAL_STORAGE");
  IElementType TYPE = new LLVMElementType("TYPE");
  IElementType TYPED_VALUE = new LLVMElementType("TYPED_VALUE");
  IElementType USER_DEFINED_TYPE = new LLVMElementType("USER_DEFINED_TYPE");
  IElementType VALUE = new LLVMElementType("VALUE");
  IElementType VECTOR_TYPE = new LLVMElementType("VECTOR_TYPE");
  IElementType VISIBILITY = new LLVMElementType("VISIBILITY");

  IElementType ACQUIRE = new LLVMTokenType("acquire");
  IElementType ACQ_REL = new LLVMTokenType("acq_rel");
  IElementType ADD = new LLVMTokenType("add");
  IElementType ADDRSPACE = new LLVMTokenType("addrspace");
  IElementType ADDRSPACECAST = new LLVMTokenType("addrspacecast");
  IElementType ALIAS = new LLVMTokenType("alias");
  IElementType ALIGN = new LLVMTokenType("align");
  IElementType ALIGNSTACK = new LLVMTokenType("alignstack");
  IElementType ALLOCA = new LLVMTokenType("alloca");
  IElementType ALWAYSINLINE = new LLVMTokenType("alwaysinline");
  IElementType AND = new LLVMTokenType("and");
  IElementType ANY = new LLVMTokenType("any");
  IElementType ANYREGCC = new LLVMTokenType("anyregcc");
  IElementType APPENDING = new LLVMTokenType("appending");
  IElementType ARCP = new LLVMTokenType("arcp");
  IElementType ARGMEMONLY = new LLVMTokenType("argmemonly");
  IElementType ARM_AAPCSCC = new LLVMTokenType("arm_aapcscc");
  IElementType ARM_AAPCS_VFPCC = new LLVMTokenType("arm_aapcs_vfpcc");
  IElementType ARM_APCSCC = new LLVMTokenType("arm_apcscc");
  IElementType ASHR = new LLVMTokenType("ashr");
  IElementType ASM = new LLVMTokenType("asm");
  IElementType ASTERISK = new LLVMTokenType("*");
  IElementType ATOMIC = new LLVMTokenType("atomic");
  IElementType ATOMICRMW = new LLVMTokenType("atomicrmw");
  IElementType ATTRIBUTES = new LLVMTokenType("attributes");
  IElementType ATT_GROUP_ID = new LLVMTokenType("ATT_GROUP_ID");
  IElementType AVAILABLE_EXTERNALLY = new LLVMTokenType("available_externally");
  IElementType BITCAST = new LLVMTokenType("bitcast");
  IElementType BLOCKADDRESS = new LLVMTokenType("blockaddress");
  IElementType BR = new LLVMTokenType("br");
  IElementType BUILTIN = new LLVMTokenType("builtin");
  IElementType BYVAL = new LLVMTokenType("byval");
  IElementType CALL = new LLVMTokenType("call");
  IElementType CALLER = new LLVMTokenType("caller");
  IElementType CATCH = new LLVMTokenType("catch");
  IElementType CATCHPAD = new LLVMTokenType("catchpad");
  IElementType CATCHRET = new LLVMTokenType("catchret");
  IElementType CATCHSWITCH = new LLVMTokenType("catchswitch");
  IElementType CC = new LLVMTokenType("cc");
  IElementType CCC = new LLVMTokenType("ccc");
  IElementType CHAR_ARRAY_LITERAL = new LLVMTokenType("CHAR_ARRAY_LITERAL");
  IElementType CLEANUP = new LLVMTokenType("cleanup");
  IElementType CLEANUPPAD = new LLVMTokenType("cleanuppad");
  IElementType CLEANUPRET = new LLVMTokenType("cleanupret");
  IElementType CMPXCHG = new LLVMTokenType("cmpxchg");
  IElementType COLD = new LLVMTokenType("cold");
  IElementType COLDCC = new LLVMTokenType("coldcc");
  IElementType COMDAT_IDENTIFIER = new LLVMTokenType("COMDAT_IDENTIFIER");
  IElementType COMMA = new LLVMTokenType(",");
  IElementType COMMENT = new LLVMTokenType("COMMENT");
  IElementType COMMON = new LLVMTokenType("common");
  IElementType CONSTANT = new LLVMTokenType("constant");
  IElementType CONVERGENT = new LLVMTokenType("convergent");
  IElementType CXX_FAST_TLSCC = new LLVMTokenType("cxx_fast_tlscc");
  IElementType DATALAYOUT = new LLVMTokenType("datalayout");
  IElementType DECIMAL_FPLITERAL = new LLVMTokenType("DECIMAL_FPLITERAL");
  IElementType DECLARE = new LLVMTokenType("declare");
  IElementType DEFAULT = new LLVMTokenType("default");
  IElementType DEFINE = new LLVMTokenType("define");
  IElementType DEPLIBS = new LLVMTokenType("deplibs");
  IElementType DEREFERENCEABLE = new LLVMTokenType("dereferenceable");
  IElementType DEREFERENCEABLE_OR_NULL = new LLVMTokenType("dereferenceable_or_null");
  IElementType DIGIT = new LLVMTokenType("digit");
  IElementType DISTINCT = new LLVMTokenType("distinct");
  IElementType DLLEXPORT = new LLVMTokenType("dllexport");
  IElementType DLLIMPORT = new LLVMTokenType("dllimport");
  IElementType EQ = new LLVMTokenType("eq");
  IElementType EXACT = new LLVMTokenType("exact");
  IElementType EXACTMATCH = new LLVMTokenType("exactmatch");
  IElementType EXTERNAL = new LLVMTokenType("external");
  IElementType EXTERNALLY_INITIALIZED = new LLVMTokenType("externally_initialized");
  IElementType EXTERN_WEAK = new LLVMTokenType("extern_weak");
  IElementType EXTRACTELEMENT = new LLVMTokenType("extractelement");
  IElementType EXTRACTVALUE = new LLVMTokenType("extractvalue");
  IElementType FADD = new LLVMTokenType("fadd");
  IElementType FALSE = new LLVMTokenType("false");
  IElementType FAST = new LLVMTokenType("fast");
  IElementType FASTCC = new LLVMTokenType("fastcc");
  IElementType FCMP = new LLVMTokenType("fcmp");
  IElementType FDIV = new LLVMTokenType("fdiv");
  IElementType FENCE = new LLVMTokenType("fence");
  IElementType FILTER = new LLVMTokenType("filter");
  IElementType FMUL = new LLVMTokenType("fmul");
  IElementType FPEXT = new LLVMTokenType("fpext");
  IElementType FPTOSI = new LLVMTokenType("fptosi");
  IElementType FPTOUI = new LLVMTokenType("fptoui");
  IElementType FPTRUNC = new LLVMTokenType("fptrunc");
  IElementType FREM = new LLVMTokenType("frem");
  IElementType FROM = new LLVMTokenType("from");
  IElementType FSUB = new LLVMTokenType("fsub");
  IElementType GC = new LLVMTokenType("gc");
  IElementType GETELEMENTPTR = new LLVMTokenType("getelementptr");
  IElementType GHCCC = new LLVMTokenType("ghccc");
  IElementType GLOBAL = new LLVMTokenType("global");
  IElementType GLOBAL_IDENTIFIER = new LLVMTokenType("GLOBAL_IDENTIFIER");
  IElementType HEX_FP128LITERAL = new LLVMTokenType("HEX_FP128LITERAL");
  IElementType HEX_FP80LITERAL = new LLVMTokenType("HEX_FP80LITERAL");
  IElementType HEX_FPLITERAL = new LLVMTokenType("HEX_FPLITERAL");
  IElementType HEX_HALF_LITERAL = new LLVMTokenType("HEX_HALF_LITERAL");
  IElementType HEX_PPC128LITERAL = new LLVMTokenType("HEX_PPC128LITERAL");
  IElementType HHVMCC = new LLVMTokenType("hhvmcc");
  IElementType HHVM_CCC = new LLVMTokenType("hhvm_ccc");
  IElementType HIDDEN = new LLVMTokenType("hidden");
  IElementType ICMP = new LLVMTokenType("icmp");
  IElementType INACCESSIBLEMEMONLY = new LLVMTokenType("inaccessiblememonly");
  IElementType INACCESSIBLEMEM_OR_ARGMEMONLY = new LLVMTokenType("inaccessiblemem_or_argmemonly");
  IElementType INALLOCA = new LLVMTokenType("inalloca");
  IElementType INBOUNDS = new LLVMTokenType("inbounds");
  IElementType INDIRECTBR = new LLVMTokenType("indirectbr");
  IElementType INITIALEXEC = new LLVMTokenType("initialexec");
  IElementType INLINEHINT = new LLVMTokenType("inlinehint");
  IElementType INREG = new LLVMTokenType("inreg");
  IElementType INSERTELEMENT = new LLVMTokenType("insertelement");
  IElementType INSERTVALUE = new LLVMTokenType("insertvalue");
  IElementType INTELDIALECT = new LLVMTokenType("inteldialect");
  IElementType INTEL_OCL_BICC = new LLVMTokenType("intel_ocl_bicc");
  IElementType INTERGER_LITERAL = new LLVMTokenType("INTERGER_LITERAL");
  IElementType INTERNAL = new LLVMTokenType("internal");
  IElementType INTTOPTR = new LLVMTokenType("inttoptr");
  IElementType INVOKE = new LLVMTokenType("invoke");
  IElementType JUMPTABLE = new LLVMTokenType("jumptable");
  IElementType KEYWORD = new LLVMTokenType("keyword");
  IElementType LABEL_ID = new LLVMTokenType("LABEL_ID");
  IElementType LANDINGPAD = new LLVMTokenType("landingpad");
  IElementType LARGEST = new LLVMTokenType("largest");
  IElementType LEFT_BRACE = new LLVMTokenType("LEFT_BRACE");
  IElementType LEFT_BRACKET = new LLVMTokenType("LEFT_BRACKET");
  IElementType LEFT_PARENTHESIS = new LLVMTokenType("LEFT_PARENTHESIS");
  IElementType LINKONCE = new LLVMTokenType("linkonce");
  IElementType LINKONCE_ODR = new LLVMTokenType("linkonce_odr");
  IElementType LOAD = new LLVMTokenType("load");
  IElementType LOCALDYNAMIC = new LLVMTokenType("localdynamic");
  IElementType LOCALEXEC = new LLVMTokenType("localexec");
  IElementType LOCAL_IDENTIFIER = new LLVMTokenType("LOCAL_IDENTIFIER");
  IElementType LSHL = new LLVMTokenType("lshl");
  IElementType LSHR = new LLVMTokenType("lshr");
  IElementType MAX = new LLVMTokenType("max");
  IElementType METADATA_IDENTIFIER = new LLVMTokenType("METADATA_IDENTIFIER");
  IElementType METADATA_LEFT_BRACE = new LLVMTokenType("!{");
  IElementType METADATA_STRING = new LLVMTokenType("METADATA_STRING");
  IElementType MIN = new LLVMTokenType("min");
  IElementType MINSIZE = new LLVMTokenType("minsize");
  IElementType MONOTONIC = new LLVMTokenType("monotonic");
  IElementType MSP430_INTRCC = new LLVMTokenType("msp430_intrcc");
  IElementType MUL = new LLVMTokenType("mul");
  IElementType MUSTTAIL = new LLVMTokenType("musttail");
  IElementType NAKED = new LLVMTokenType("naked");
  IElementType NAND = new LLVMTokenType("nand");
  IElementType NE = new LLVMTokenType("ne");
  IElementType NEST = new LLVMTokenType("nest");
  IElementType NINF = new LLVMTokenType("ninf");
  IElementType NNAN = new LLVMTokenType("nnan");
  IElementType NOALIAS = new LLVMTokenType("noalias");
  IElementType NOBUILTIN = new LLVMTokenType("nobuiltin");
  IElementType NOCAPTURE = new LLVMTokenType("nocapture");
  IElementType NODUPLICATE = new LLVMTokenType("noduplicate");
  IElementType NODUPLICATES = new LLVMTokenType("noduplicates");
  IElementType NOIMPLICITFLOAT = new LLVMTokenType("noimplicitfloat");
  IElementType NOINLINE = new LLVMTokenType("noinline");
  IElementType NONE = new LLVMTokenType("none");
  IElementType NONLAZYBIND = new LLVMTokenType("nonlazybind");
  IElementType NONNULL = new LLVMTokenType("nonnull");
  IElementType NORECURSE = new LLVMTokenType("norecurse");
  IElementType NOREDZONE = new LLVMTokenType("noredzone");
  IElementType NORETURN = new LLVMTokenType("noreturn");
  IElementType NOTAIL = new LLVMTokenType("notail");
  IElementType NOUNWIND = new LLVMTokenType("nounwind");
  IElementType NSW = new LLVMTokenType("nsw");
  IElementType NSZ = new LLVMTokenType("nsz");
  IElementType NULL = new LLVMTokenType("null");
  IElementType NUW = new LLVMTokenType("nuw");
  IElementType OEQ = new LLVMTokenType("oeq");
  IElementType OGE = new LLVMTokenType("oge");
  IElementType OGT = new LLVMTokenType("ogt");
  IElementType OLE = new LLVMTokenType("ole");
  IElementType OLT = new LLVMTokenType("olt");
  IElementType ONE = new LLVMTokenType("one");
  IElementType OPERATOR = new LLVMTokenType("OPERATOR");
  IElementType OPTNONE = new LLVMTokenType("optnone");
  IElementType OPTSIZE = new LLVMTokenType("optsize");
  IElementType OR = new LLVMTokenType("or");
  IElementType ORD = new LLVMTokenType("ord");
  IElementType PERSONALITY = new LLVMTokenType("personality");
  IElementType PHI = new LLVMTokenType("phi");
  IElementType PREFIX = new LLVMTokenType("prefix");
  IElementType PRESERVE_ALLCC = new LLVMTokenType("preserve_allcc");
  IElementType PRESERVE_MOSTCC = new LLVMTokenType("preserve_mostcc");
  IElementType PRIVATE = new LLVMTokenType("private");
  IElementType PROLOGUE = new LLVMTokenType("prologue");
  IElementType PROTECTED = new LLVMTokenType("protected");
  IElementType PTRTOINT = new LLVMTokenType("ptrtoint");
  IElementType PTX_DEVICE = new LLVMTokenType("ptx_device");
  IElementType PTX_KERNEL = new LLVMTokenType("ptx_kernel");
  IElementType READNONE = new LLVMTokenType("readnone");
  IElementType READONLY = new LLVMTokenType("readonly");
  IElementType RELEASE = new LLVMTokenType("release");
  IElementType RESUME = new LLVMTokenType("resume");
  IElementType RET = new LLVMTokenType("ret");
  IElementType RETURNED = new LLVMTokenType("returned");
  IElementType RETURNS_TWICE = new LLVMTokenType("returns_twice");
  IElementType RIGHT_BRACE = new LLVMTokenType("RIGHT_BRACE");
  IElementType RIGHT_BRACKET = new LLVMTokenType("RIGHT_BRACKET");
  IElementType RIGHT_PARENTHESIS = new LLVMTokenType("RIGHT_PARENTHESIS");
  IElementType SAFESTACK = new LLVMTokenType("safestack");
  IElementType SAMESIZE = new LLVMTokenType("samesize");
  IElementType SANITIZE_ADDRESS = new LLVMTokenType("sanitize_address");
  IElementType SANITIZE_MEMORY = new LLVMTokenType("sanitize_memory");
  IElementType SANITIZE_THREAD = new LLVMTokenType("sanitize_thread");
  IElementType SDIV = new LLVMTokenType("sdiv");
  IElementType SELECT = new LLVMTokenType("select");
  IElementType SEQ_CST = new LLVMTokenType("seq_cst");
  IElementType SEXT = new LLVMTokenType("sext");
  IElementType SGE = new LLVMTokenType("sge");
  IElementType SGT = new LLVMTokenType("sgt");
  IElementType SHL = new LLVMTokenType("shl");
  IElementType SHUFFLEVECTOR = new LLVMTokenType("shufflevector");
  IElementType SIDEEFFECT = new LLVMTokenType("sideeffect");
  IElementType SIGNEXT = new LLVMTokenType("signext");
  IElementType SINGLETHREAD = new LLVMTokenType("singlethread");
  IElementType SITOFP = new LLVMTokenType("sitofp");
  IElementType SLE = new LLVMTokenType("sle");
  IElementType SLT = new LLVMTokenType("slt");
  IElementType SPIR_FUNC = new LLVMTokenType("spir_func");
  IElementType SPIR_KERNEL = new LLVMTokenType("spir_kernel");
  IElementType SREM = new LLVMTokenType("srem");
  IElementType SRET = new LLVMTokenType("sret");
  IElementType SSP = new LLVMTokenType("ssp");
  IElementType SSPREQ = new LLVMTokenType("sspreq");
  IElementType SSPSTRONG = new LLVMTokenType("sspstrong");
  IElementType STORE = new LLVMTokenType("store");
  IElementType STRING = new LLVMTokenType("STRING");
  IElementType SUB = new LLVMTokenType("sub");
  IElementType SWITCH = new LLVMTokenType("switch");
  IElementType TAIL = new LLVMTokenType("tail");
  IElementType TARGET = new LLVMTokenType("target");
  IElementType THREAD_LOCAL = new LLVMTokenType("thread_local");
  IElementType THUNK = new LLVMTokenType("thunk");
  IElementType TIMES = new LLVMTokenType("x");
  IElementType TO = new LLVMTokenType("to");
  IElementType TRIPLE = new LLVMTokenType("triple");
  IElementType TRUE = new LLVMTokenType("true");
  IElementType TRUNC = new LLVMTokenType("trunc");
  IElementType TYPE_LITERAL = new LLVMTokenType("TYPE_LITERAL");
  IElementType UDIV = new LLVMTokenType("udiv");
  IElementType UEQ = new LLVMTokenType("ueq");
  IElementType UGE = new LLVMTokenType("uge");
  IElementType UGT = new LLVMTokenType("ugt");
  IElementType UITOFP = new LLVMTokenType("uitofp");
  IElementType ULE = new LLVMTokenType("ule");
  IElementType ULT = new LLVMTokenType("ult");
  IElementType UMAX = new LLVMTokenType("umax");
  IElementType UMIN = new LLVMTokenType("umin");
  IElementType UNDEF = new LLVMTokenType("undef");
  IElementType UNE = new LLVMTokenType("une");
  IElementType UNNAMED_ADDR = new LLVMTokenType("unnamed_addr");
  IElementType UNO = new LLVMTokenType("uno");
  IElementType UNORDERED = new LLVMTokenType("unordered");
  IElementType UNREACHABLE = new LLVMTokenType("unreachable");
  IElementType UNWIND = new LLVMTokenType("unwind");
  IElementType UREM = new LLVMTokenType("urem");
  IElementType UWTABLE = new LLVMTokenType("uwtable");
  IElementType VA_ARG = new LLVMTokenType("va_arg");
  IElementType VOID = new LLVMTokenType("void");
  IElementType VOLATILE = new LLVMTokenType("volatile");
  IElementType WEAK = new LLVMTokenType("weak");
  IElementType WEAK_ODR = new LLVMTokenType("weak_odr");
  IElementType WEBKIT_JSCC = new LLVMTokenType("webkit_jscc");
  IElementType WITHIN = new LLVMTokenType("within");
  IElementType X86_64_SYSVCC = new LLVMTokenType("x86_64_sysvcc");
  IElementType X86_64_WIN64CC = new LLVMTokenType("x86_64_win64cc");
  IElementType X86_FASTCALLCC = new LLVMTokenType("x86_fastcallcc");
  IElementType X86_INTRCC = new LLVMTokenType("x86_intrcc");
  IElementType X86_STDCALLCC = new LLVMTokenType("x86_stdcallcc");
  IElementType X86_THISCALLCC = new LLVMTokenType("x86_thiscallcc");
  IElementType X86_VECTORCALLCC = new LLVMTokenType("x86_vectorcallcc");
  IElementType XCHG = new LLVMTokenType("xchg");
  IElementType XOR = new LLVMTokenType("xor");
  IElementType ZEROEXT = new LLVMTokenType("zeroext");
  IElementType ZEROINITIALIZER = new LLVMTokenType("zeroinitializer");
  IElementType ZEXT = new LLVMTokenType("zext");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ADDRESS_SPACE) {
        return new LLVMAddressSpaceImpl(node);
      }
      else if (type == ADDRESS_SPACE_TYPE) {
        return new LLVMAddressSpaceTypeImpl(node);
      }
      else if (type == ALIGNMENT) {
        return new LLVMAlignmentImpl(node);
      }
      else if (type == ARGUMENT) {
        return new LLVMArgumentImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new LLVMArgumentListImpl(node);
      }
      else if (type == ARRAY_TYPE) {
        return new LLVMArrayTypeImpl(node);
      }
      else if (type == ATOMIC_ORDERING) {
        return new LLVMAtomicOrderingImpl(node);
      }
      else if (type == BASIC_BLOCK) {
        return new LLVMBasicBlockImpl(node);
      }
      else if (type == CALLING_CONVENTION) {
        return new LLVMCallingConventionImpl(node);
      }
      else if (type == CLAUSE) {
        return new LLVMClauseImpl(node);
      }
      else if (type == COMDAT) {
        return new LLVMComdatImpl(node);
      }
      else if (type == DLL_STORAGE_CLASS) {
        return new LLVMDllStorageClassImpl(node);
      }
      else if (type == ENTITY) {
        return new LLVMEntityImpl(node);
      }
      else if (type == FAST_MATHS_FLAG) {
        return new LLVMFastMathsFlagImpl(node);
      }
      else if (type == FLOAT_LITERAL) {
        return new LLVMFloatLiteralImpl(node);
      }
      else if (type == FP_PREDICATE) {
        return new LLVMFPPredicateImpl(node);
      }
      else if (type == FUNCTION_ATTRIBUTE) {
        return new LLVMFunctionAttributeImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new LLVMFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new LLVMFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new LLVMFunctionDefinitionImpl(node);
      }
      else if (type == FUNCTION_HEADER) {
        return new LLVMFunctionHeaderImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new LLVMFunctionTypeImpl(node);
      }
      else if (type == INDEX) {
        return new LLVMIndexImpl(node);
      }
      else if (type == INSTRUCTION) {
        return new LLVMInstructionImpl(node);
      }
      else if (type == INT_PREDICATE) {
        return new LLVMIntPredicateImpl(node);
      }
      else if (type == LINKAGE) {
        return new LLVMLinkageImpl(node);
      }
      else if (type == METADATA) {
        return new LLVMMetadataImpl(node);
      }
      else if (type == OPERAND_BUNDLE) {
        return new LLVMOperandBundleImpl(node);
      }
      else if (type == OPERATION) {
        return new LLVMOperationImpl(node);
      }
      else if (type == PACKED_STRUCTURE_TYPE) {
        return new LLVMPackedStructureTypeImpl(node);
      }
      else if (type == PARAMETER) {
        return new LLVMParameterImpl(node);
      }
      else if (type == PARAMETER_ATTRIBUTE) {
        return new LLVMParameterAttributeImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new LLVMParameterListImpl(node);
      }
      else if (type == POINTER_TYPE) {
        return new LLVMPointerTypeImpl(node);
      }
      else if (type == PRIMITIVE_TYPE) {
        return new LLVMPrimitiveTypeImpl(node);
      }
      else if (type == RETURN_ATTRIBUTE) {
        return new LLVMReturnAttributeImpl(node);
      }
      else if (type == SCOPE) {
        return new LLVMScopeImpl(node);
      }
      else if (type == SECTION) {
        return new LLVMSectionImpl(node);
      }
      else if (type == SELECTION_KIND) {
        return new LLVMSelectionKindImpl(node);
      }
      else if (type == STATEMENT) {
        return new LLVMStatementImpl(node);
      }
      else if (type == STRUCTURE_TYPE) {
        return new LLVMStructureTypeImpl(node);
      }
      else if (type == THREAD_LOCAL_STORAGE) {
        return new LLVMThreadLocalStorageImpl(node);
      }
      else if (type == TYPED_VALUE) {
        return new LLVMTypedValueImpl(node);
      }
      else if (type == USER_DEFINED_TYPE) {
        return new LLVMUserDefinedTypeImpl(node);
      }
      else if (type == VALUE) {
        return new LLVMValueImpl(node);
      }
      else if (type == VECTOR_TYPE) {
        return new LLVMVectorTypeImpl(node);
      }
      else if (type == VISIBILITY) {
        return new LLVMVisibilityImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
