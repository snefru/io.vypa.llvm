// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import static io.vypa.llvm.parser.LLVMParserUtil.*;
import static io.vypa.llvm.psi.LLVMTypes.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LLVMParser implements PsiParser, LightPsiParser {

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ADDRESS_SPACE_TYPE, ARRAY_TYPE, FUNCTION_TYPE, PACKED_STRUCTURE_TYPE,
      POINTER_TYPE, PRIMITIVE_TYPE, STRUCTURE_TYPE, TYPE,
      USER_DEFINED_TYPE, VECTOR_TYPE),
  };

  /* ********************************************************** */
  // addrspace '(' INTERGER_LITERAL ')'
  public static boolean AddressSpace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AddressSpace")) return false;
    if (!nextTokenIs(b, ADDRSPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ADDRSPACE);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, ADDRESS_SPACE, r);
    return r;
  }

  /* ********************************************************** */
  // align INTERGER_LITERAL
  public static boolean Alignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Alignment")) return false;
    if (!nextTokenIs(b, ALIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIGN, INTERGER_LITERAL);
    exit_section_(b, m, ALIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Type ParameterAttribute* METADATA_IDENTIFIER  //todo review
  //                     |   Type ParameterAttribute* Value
  public static boolean Argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<argument>");
    r = Argument_0(b, l + 1);
    if (!r) r = Argument_1(b, l + 1);
    exit_section_(b, l, m, ARGUMENT, r, false, null);
    return r;
  }

  // Type ParameterAttribute* METADATA_IDENTIFIER
  private static boolean Argument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1, -1);
    r = r && Argument_0_1(b, l + 1);
    r = r && consumeToken(b, METADATA_IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParameterAttribute*
  private static boolean Argument_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ParameterAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Argument_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // Type ParameterAttribute* Value
  private static boolean Argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1, -1);
    r = r && Argument_1_1(b, l + 1);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParameterAttribute*
  private static boolean Argument_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ParameterAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Argument_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // Argument(',' Argument)*
  public static boolean ArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<argument list>");
    r = Argument(b, l + 1);
    r = r && ArgumentList_1(b, l + 1);
    exit_section_(b, l, m, ARGUMENT_LIST, r, false, null);
    return r;
  }

  // (',' Argument)*
  private static boolean ArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ArgumentList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArgumentList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Argument
  private static boolean ArgumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unordered
  //                     |   monotonic
  //                     |   acquire
  //                     |   release
  //                     |   acq_rel
  //                     |   seq_cst
  public static boolean AtomicOrdering(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomicOrdering")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<atomic ordering>");
    r = consumeToken(b, UNORDERED);
    if (!r) r = consumeToken(b, MONOTONIC);
    if (!r) r = consumeToken(b, ACQUIRE);
    if (!r) r = consumeToken(b, RELEASE);
    if (!r) r = consumeToken(b, ACQ_REL);
    if (!r) r = consumeToken(b, SEQ_CST);
    exit_section_(b, l, m, ATOMIC_ORDERING, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (LABEL_ID)? (Statement)+
  //                     |   LABEL_ID
  public static boolean BasicBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BasicBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<basic block>");
    r = BasicBlock_0(b, l + 1);
    if (!r) r = consumeToken(b, LABEL_ID);
    exit_section_(b, l, m, BASIC_BLOCK, r, false, null);
    return r;
  }

  // (LABEL_ID)? (Statement)+
  private static boolean BasicBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BasicBlock_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BasicBlock_0_0(b, l + 1);
    r = r && BasicBlock_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LABEL_ID)?
  private static boolean BasicBlock_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BasicBlock_0_0")) return false;
    consumeToken(b, LABEL_ID);
    return true;
  }

  // (Statement)+
  private static boolean BasicBlock_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BasicBlock_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BasicBlock_0_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!BasicBlock_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BasicBlock_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (Statement)
  private static boolean BasicBlock_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BasicBlock_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ccc
  //                     |   fastcc
  //                     |   coldcc
  //                     |   x86_stdcallcc
  //                     |   x86_fastcallcc
  //                     |   x86_thiscallcc
  //                     |   x86_vectorcallcc
  //                     |   arm_apcscc
  //                     |   arm_aapcscc
  //                     |   arm_aapcs_vfpcc
  //                     |   msp430_intrcc
  //                     |   ptx_kernel
  //                     |   ptx_device
  //                     |   spir_kernel
  //                     |   spir_func
  //                     |   intel_ocl_bicc
  //                     |   x86_64_sysvcc
  //                     |   x86_64_win64cc
  //                     |   webkit_jscc
  //                     |   anyregcc
  //                     |   preserve_mostcc
  //                     |   preserve_allcc
  //                     |   ghccc
  //                     |   x86_intrcc
  //                     |   hhvmcc
  //                     |   hhvm_ccc
  //                     |   cxx_fast_tlscc
  //                     |   cc digit+
  public static boolean CallingConvention(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallingConvention")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<calling convention>");
    r = consumeToken(b, CCC);
    if (!r) r = consumeToken(b, FASTCC);
    if (!r) r = consumeToken(b, COLDCC);
    if (!r) r = consumeToken(b, X86_STDCALLCC);
    if (!r) r = consumeToken(b, X86_FASTCALLCC);
    if (!r) r = consumeToken(b, X86_THISCALLCC);
    if (!r) r = consumeToken(b, X86_VECTORCALLCC);
    if (!r) r = consumeToken(b, ARM_APCSCC);
    if (!r) r = consumeToken(b, ARM_AAPCSCC);
    if (!r) r = consumeToken(b, ARM_AAPCS_VFPCC);
    if (!r) r = consumeToken(b, MSP430_INTRCC);
    if (!r) r = consumeToken(b, PTX_KERNEL);
    if (!r) r = consumeToken(b, PTX_DEVICE);
    if (!r) r = consumeToken(b, SPIR_KERNEL);
    if (!r) r = consumeToken(b, SPIR_FUNC);
    if (!r) r = consumeToken(b, INTEL_OCL_BICC);
    if (!r) r = consumeToken(b, X86_64_SYSVCC);
    if (!r) r = consumeToken(b, X86_64_WIN64CC);
    if (!r) r = consumeToken(b, WEBKIT_JSCC);
    if (!r) r = consumeToken(b, ANYREGCC);
    if (!r) r = consumeToken(b, PRESERVE_MOSTCC);
    if (!r) r = consumeToken(b, PRESERVE_ALLCC);
    if (!r) r = consumeToken(b, GHCCC);
    if (!r) r = consumeToken(b, X86_INTRCC);
    if (!r) r = consumeToken(b, HHVMCC);
    if (!r) r = consumeToken(b, HHVM_CCC);
    if (!r) r = consumeToken(b, CXX_FAST_TLSCC);
    if (!r) r = CallingConvention_27(b, l + 1);
    exit_section_(b, l, m, CALLING_CONVENTION, r, false, null);
    return r;
  }

  // cc digit+
  private static boolean CallingConvention_27(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallingConvention_27")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CC);
    r = r && CallingConvention_27_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // digit+
  private static boolean CallingConvention_27_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallingConvention_27_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DIGIT);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, DIGIT)) break;
      if (!empty_element_parsed_guard_(b, "CallingConvention_27_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // catch TypedValue
  //                     |   filter TypedValue
  public static boolean Clause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Clause")) return false;
    if (!nextTokenIs(b, "<clause>", CATCH, FILTER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<clause>");
    r = Clause_0(b, l + 1);
    if (!r) r = Clause_1(b, l + 1);
    exit_section_(b, l, m, CLAUSE, r, false, null);
    return r;
  }

  // catch TypedValue
  private static boolean Clause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Clause_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // filter TypedValue
  private static boolean Clause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Clause_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FILTER);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'comdat' ( '('  COMDAT_IDENTIFIER ')' )?
  public static boolean Comdat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comdat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<comdat>");
    r = consumeToken(b, "comdat");
    r = r && Comdat_1(b, l + 1);
    exit_section_(b, l, m, COMDAT, r, false, null);
    return r;
  }

  // ( '('  COMDAT_IDENTIFIER ')' )?
  private static boolean Comdat_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comdat_1")) return false;
    Comdat_1_0(b, l + 1);
    return true;
  }

  // '('  COMDAT_IDENTIFIER ')'
  private static boolean Comdat_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comdat_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && consumeToken(b, COMDAT_IDENTIFIER);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dllimport
  //                     |   dllexport
  public static boolean DllStorageClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DllStorageClass")) return false;
    if (!nextTokenIs(b, "<dll storage class>", DLLEXPORT, DLLIMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<dll storage class>");
    r = consumeToken(b, DLLIMPORT);
    if (!r) r = consumeToken(b, DLLEXPORT);
    exit_section_(b, l, m, DLL_STORAGE_CLASS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // define FunctionHeader FunctionBody
  //                     |   declare FunctionHeader
  //                     |   'module' asm  STRING
  //                     |   target triple '='  STRING
  //                     |   target datalayout '='  STRING
  //                     |   deplibs '=' '[' ']'
  //                     |   deplibs '=' '['  STRING (','  STRING)* ']'
  //                     |   LOCAL_IDENTIFIER '=' 'type' Type
  //                     |   GLOBAL_IDENTIFIER '='   Linkage?
  //                                                 Visibility?
  //                                                 DllStorageClass?
  //                                                 (thread_local ('(' ThreadLocalStorage ')')?)?
  //                                                 unnamed_addr?
  //                                                 AddressSpace?
  //                                                 externally_initialized?
  //                                                 Scope
  //                                                 Type
  //                                                 Value?
  //                                                 (',' Section)?
  //                                                 (',' Comdat)?
  //                                                 (',' Alignment)?
  //                     |   GLOBAL_IDENTIFIER '='    Linkage?
  //                                                 Visibility?
  //                                                 DllStorageClass?
  //                                                 (thread_local ('(' ThreadLocalStorage ')')?)?
  //                                                 unnamed_addr?
  //                                                 alias
  //                                                 TypedValue
  //                     |   COMDAT_IDENTIFIER '=' 'comdat' SelectionKind
  //                     |   METADATA_IDENTIFIER '=' distinct? Metadata
  //                     |   attributes ATT_GROUP_ID '=' '{' FunctionAttribute* '}'
  public static boolean Entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<entity>");
    r = Entity_0(b, l + 1);
    if (!r) r = Entity_1(b, l + 1);
    if (!r) r = Entity_2(b, l + 1);
    if (!r) r = Entity_3(b, l + 1);
    if (!r) r = Entity_4(b, l + 1);
    if (!r) r = Entity_5(b, l + 1);
    if (!r) r = Entity_6(b, l + 1);
    if (!r) r = Entity_7(b, l + 1);
    if (!r) r = Entity_8(b, l + 1);
    if (!r) r = Entity_9(b, l + 1);
    if (!r) r = Entity_10(b, l + 1);
    if (!r) r = Entity_11(b, l + 1);
    if (!r) r = Entity_12(b, l + 1);
    exit_section_(b, l, m, ENTITY, r, false, null);
    return r;
  }

  // define FunctionHeader FunctionBody
  private static boolean Entity_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINE);
    r = r && FunctionHeader(b, l + 1);
    r = r && FunctionBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // declare FunctionHeader
  private static boolean Entity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DECLARE);
    r = r && FunctionHeader(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'module' asm  STRING
  private static boolean Entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "module");
    r = r && consumeTokens(b, 0, ASM, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // target triple '='  STRING
  private static boolean Entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TARGET, TRIPLE);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // target datalayout '='  STRING
  private static boolean Entity_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TARGET, DATALAYOUT);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // deplibs '=' '[' ']'
  private static boolean Entity_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEPLIBS);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, "[");
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // deplibs '=' '['  STRING (','  STRING)* ']'
  private static boolean Entity_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEPLIBS);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, "[");
    r = r && consumeToken(b, STRING);
    r = r && Entity_6_4(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (','  STRING)*
  private static boolean Entity_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_6_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Entity_6_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Entity_6_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ','  STRING
  private static boolean Entity_6_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_6_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // LOCAL_IDENTIFIER '=' 'type' Type
  private static boolean Entity_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL_IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, "type");
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GLOBAL_IDENTIFIER '='   Linkage?
  //                                                 Visibility?
  //                                                 DllStorageClass?
  //                                                 (thread_local ('(' ThreadLocalStorage ')')?)?
  //                                                 unnamed_addr?
  //                                                 AddressSpace?
  //                                                 externally_initialized?
  //                                                 Scope
  //                                                 Type
  //                                                 Value?
  //                                                 (',' Section)?
  //                                                 (',' Comdat)?
  //                                                 (',' Alignment)?
  private static boolean Entity_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL_IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && Entity_8_2(b, l + 1);
    r = r && Entity_8_3(b, l + 1);
    r = r && Entity_8_4(b, l + 1);
    r = r && Entity_8_5(b, l + 1);
    r = r && Entity_8_6(b, l + 1);
    r = r && Entity_8_7(b, l + 1);
    r = r && Entity_8_8(b, l + 1);
    r = r && Scope(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Entity_8_11(b, l + 1);
    r = r && Entity_8_12(b, l + 1);
    r = r && Entity_8_13(b, l + 1);
    r = r && Entity_8_14(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Linkage?
  private static boolean Entity_8_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_2")) return false;
    Linkage(b, l + 1);
    return true;
  }

  // Visibility?
  private static boolean Entity_8_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_3")) return false;
    Visibility(b, l + 1);
    return true;
  }

  // DllStorageClass?
  private static boolean Entity_8_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_4")) return false;
    DllStorageClass(b, l + 1);
    return true;
  }

  // (thread_local ('(' ThreadLocalStorage ')')?)?
  private static boolean Entity_8_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_5")) return false;
    Entity_8_5_0(b, l + 1);
    return true;
  }

  // thread_local ('(' ThreadLocalStorage ')')?
  private static boolean Entity_8_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THREAD_LOCAL);
    r = r && Entity_8_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('(' ThreadLocalStorage ')')?
  private static boolean Entity_8_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_5_0_1")) return false;
    Entity_8_5_0_1_0(b, l + 1);
    return true;
  }

  // '(' ThreadLocalStorage ')'
  private static boolean Entity_8_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && ThreadLocalStorage(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // unnamed_addr?
  private static boolean Entity_8_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_6")) return false;
    consumeToken(b, UNNAMED_ADDR);
    return true;
  }

  // AddressSpace?
  private static boolean Entity_8_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_7")) return false;
    AddressSpace(b, l + 1);
    return true;
  }

  // externally_initialized?
  private static boolean Entity_8_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_8")) return false;
    consumeToken(b, EXTERNALLY_INITIALIZED);
    return true;
  }

  // Value?
  private static boolean Entity_8_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_11")) return false;
    Value(b, l + 1);
    return true;
  }

  // (',' Section)?
  private static boolean Entity_8_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_12")) return false;
    Entity_8_12_0(b, l + 1);
    return true;
  }

  // ',' Section
  private static boolean Entity_8_12_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_12_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Section(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Comdat)?
  private static boolean Entity_8_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_13")) return false;
    Entity_8_13_0(b, l + 1);
    return true;
  }

  // ',' Comdat
  private static boolean Entity_8_13_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_13_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Comdat(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Alignment)?
  private static boolean Entity_8_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_14")) return false;
    Entity_8_14_0(b, l + 1);
    return true;
  }

  // ',' Alignment
  private static boolean Entity_8_14_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_8_14_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Alignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GLOBAL_IDENTIFIER '='    Linkage?
  //                                                 Visibility?
  //                                                 DllStorageClass?
  //                                                 (thread_local ('(' ThreadLocalStorage ')')?)?
  //                                                 unnamed_addr?
  //                                                 alias
  //                                                 TypedValue
  private static boolean Entity_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL_IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && Entity_9_2(b, l + 1);
    r = r && Entity_9_3(b, l + 1);
    r = r && Entity_9_4(b, l + 1);
    r = r && Entity_9_5(b, l + 1);
    r = r && Entity_9_6(b, l + 1);
    r = r && consumeToken(b, ALIAS);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Linkage?
  private static boolean Entity_9_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_2")) return false;
    Linkage(b, l + 1);
    return true;
  }

  // Visibility?
  private static boolean Entity_9_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_3")) return false;
    Visibility(b, l + 1);
    return true;
  }

  // DllStorageClass?
  private static boolean Entity_9_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_4")) return false;
    DllStorageClass(b, l + 1);
    return true;
  }

  // (thread_local ('(' ThreadLocalStorage ')')?)?
  private static boolean Entity_9_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_5")) return false;
    Entity_9_5_0(b, l + 1);
    return true;
  }

  // thread_local ('(' ThreadLocalStorage ')')?
  private static boolean Entity_9_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THREAD_LOCAL);
    r = r && Entity_9_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('(' ThreadLocalStorage ')')?
  private static boolean Entity_9_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_5_0_1")) return false;
    Entity_9_5_0_1_0(b, l + 1);
    return true;
  }

  // '(' ThreadLocalStorage ')'
  private static boolean Entity_9_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && ThreadLocalStorage(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // unnamed_addr?
  private static boolean Entity_9_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_9_6")) return false;
    consumeToken(b, UNNAMED_ADDR);
    return true;
  }

  // COMDAT_IDENTIFIER '=' 'comdat' SelectionKind
  private static boolean Entity_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMDAT_IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, "comdat");
    r = r && SelectionKind(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // METADATA_IDENTIFIER '=' distinct? Metadata
  private static boolean Entity_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METADATA_IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && Entity_11_2(b, l + 1);
    r = r && Metadata(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // distinct?
  private static boolean Entity_11_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_11_2")) return false;
    consumeToken(b, DISTINCT);
    return true;
  }

  // attributes ATT_GROUP_ID '=' '{' FunctionAttribute* '}'
  private static boolean Entity_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ATTRIBUTES, ATT_GROUP_ID);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, "{");
    r = r && Entity_12_4(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // FunctionAttribute*
  private static boolean Entity_12_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_12_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Entity_12_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // oeq
  //                     |   one
  //                     |   olt
  //                     |   ogt
  //                     |   ole
  //                     |   oge
  //                     |   ord
  //                     |   uno
  //                     |   ueq
  //                     |   une
  //                     |   ult
  //                     |   ugt
  //                     |   ule
  //                     |   uge
  //                     |   true
  //                     |   false
  public static boolean FPPredicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FPPredicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<fp predicate>");
    r = consumeToken(b, OEQ);
    if (!r) r = consumeToken(b, ONE);
    if (!r) r = consumeToken(b, OLT);
    if (!r) r = consumeToken(b, OGT);
    if (!r) r = consumeToken(b, OLE);
    if (!r) r = consumeToken(b, OGE);
    if (!r) r = consumeToken(b, ORD);
    if (!r) r = consumeToken(b, UNO);
    if (!r) r = consumeToken(b, UEQ);
    if (!r) r = consumeToken(b, UNE);
    if (!r) r = consumeToken(b, ULT);
    if (!r) r = consumeToken(b, UGT);
    if (!r) r = consumeToken(b, ULE);
    if (!r) r = consumeToken(b, UGE);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, FP_PREDICATE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fast
  //                     |   nnan
  //                     |   ninf
  //                     |   nsz
  //                     |   arcp
  public static boolean FastMathsFlag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FastMathsFlag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<fast maths flag>");
    r = consumeToken(b, FAST);
    if (!r) r = consumeToken(b, NNAN);
    if (!r) r = consumeToken(b, NINF);
    if (!r) r = consumeToken(b, NSZ);
    if (!r) r = consumeToken(b, ARCP);
    exit_section_(b, l, m, FAST_MATHS_FLAG, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HEX_FPLITERAL
  //                     |   HEX_FP80LITERAL
  //                     |   HEX_FP128LITERAL
  //                     |   HEX_PPC128LITERAL
  //                     |   HEX_HALF_LITERAL
  //                     |   DECIMAL_FPLITERAL
  public static boolean FloatLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FloatLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<float literal>");
    r = consumeToken(b, HEX_FPLITERAL);
    if (!r) r = consumeToken(b, HEX_FP80LITERAL);
    if (!r) r = consumeToken(b, HEX_FP128LITERAL);
    if (!r) r = consumeToken(b, HEX_PPC128LITERAL);
    if (!r) r = consumeToken(b, HEX_HALF_LITERAL);
    if (!r) r = consumeToken(b, DECIMAL_FPLITERAL);
    exit_section_(b, l, m, FLOAT_LITERAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ATT_GROUP_ID ('{' FunctionAttribute* '}')?
  //                     |   alignstack INTERGER_LITERAL
  //                     |   alignstack '=' INTERGER_LITERAL  //attribute group format
  //                     |   align INTERGER_LITERAL
  //                     |   align '=' INTERGER_LITERAL      //attribute group format
  //                     |   STRING '='  STRING
  //                     |   alwaysinline
  //                     |   builtin
  //                     |   cold
  //                     |   convergent
  //                     |   inaccessiblememonly
  //                     |   inaccessiblemem_or_argmemonly
  //                     |   inlinehint
  //                     |   jumptable
  //                     |   minsize
  //                     |   naked
  //                     |   nobuiltin
  //                     |   noduplicate
  //                     |   noimplicitfloat
  //                     |   noinline
  //                     |   nonlazybind
  //                     |   noredzone
  //                     |   noreturn
  //                     |   norecurse
  //                     |   nounwind
  //                     |   optnone
  //                     |   optsize
  //                     |   readnone
  //                     |   readonly
  //                     |   argmemonly //not in c++
  //                     |   returns_twice
  //                     |   ssp
  //                     |   sspreq
  //                     |   sspstrong
  //                     |   safestack
  //                     |   sanitize_address
  //                     |   sanitize_thread
  //                     |   sanitize_memory
  //                     |   uwtable
  //                     |   thunk
  //                     |   STRING
  public static boolean FunctionAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<function attribute>");
    r = FunctionAttribute_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, ALIGNSTACK, INTERGER_LITERAL);
    if (!r) r = FunctionAttribute_2(b, l + 1);
    if (!r) r = parseTokens(b, 0, ALIGN, INTERGER_LITERAL);
    if (!r) r = FunctionAttribute_4(b, l + 1);
    if (!r) r = FunctionAttribute_5(b, l + 1);
    if (!r) r = consumeToken(b, ALWAYSINLINE);
    if (!r) r = consumeToken(b, BUILTIN);
    if (!r) r = consumeToken(b, COLD);
    if (!r) r = consumeToken(b, CONVERGENT);
    if (!r) r = consumeToken(b, INACCESSIBLEMEMONLY);
    if (!r) r = consumeToken(b, INACCESSIBLEMEM_OR_ARGMEMONLY);
    if (!r) r = consumeToken(b, INLINEHINT);
    if (!r) r = consumeToken(b, JUMPTABLE);
    if (!r) r = consumeToken(b, MINSIZE);
    if (!r) r = consumeToken(b, NAKED);
    if (!r) r = consumeToken(b, NOBUILTIN);
    if (!r) r = consumeToken(b, NODUPLICATE);
    if (!r) r = consumeToken(b, NOIMPLICITFLOAT);
    if (!r) r = consumeToken(b, NOINLINE);
    if (!r) r = consumeToken(b, NONLAZYBIND);
    if (!r) r = consumeToken(b, NOREDZONE);
    if (!r) r = consumeToken(b, NORETURN);
    if (!r) r = consumeToken(b, NORECURSE);
    if (!r) r = consumeToken(b, NOUNWIND);
    if (!r) r = consumeToken(b, OPTNONE);
    if (!r) r = consumeToken(b, OPTSIZE);
    if (!r) r = consumeToken(b, READNONE);
    if (!r) r = consumeToken(b, READONLY);
    if (!r) r = consumeToken(b, ARGMEMONLY);
    if (!r) r = consumeToken(b, RETURNS_TWICE);
    if (!r) r = consumeToken(b, SSP);
    if (!r) r = consumeToken(b, SSPREQ);
    if (!r) r = consumeToken(b, SSPSTRONG);
    if (!r) r = consumeToken(b, SAFESTACK);
    if (!r) r = consumeToken(b, SANITIZE_ADDRESS);
    if (!r) r = consumeToken(b, SANITIZE_THREAD);
    if (!r) r = consumeToken(b, SANITIZE_MEMORY);
    if (!r) r = consumeToken(b, UWTABLE);
    if (!r) r = consumeToken(b, THUNK);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, FUNCTION_ATTRIBUTE, r, false, null);
    return r;
  }

  // ATT_GROUP_ID ('{' FunctionAttribute* '}')?
  private static boolean FunctionAttribute_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATT_GROUP_ID);
    r = r && FunctionAttribute_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('{' FunctionAttribute* '}')?
  private static boolean FunctionAttribute_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute_0_1")) return false;
    FunctionAttribute_0_1_0(b, l + 1);
    return true;
  }

  // '{' FunctionAttribute* '}'
  private static boolean FunctionAttribute_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && FunctionAttribute_0_1_0_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // FunctionAttribute*
  private static boolean FunctionAttribute_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute_0_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionAttribute_0_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // alignstack '=' INTERGER_LITERAL
  private static boolean FunctionAttribute_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALIGNSTACK);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, INTERGER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // align '=' INTERGER_LITERAL
  private static boolean FunctionAttribute_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALIGN);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, INTERGER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING '='  STRING
  private static boolean FunctionAttribute_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionAttribute_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' BasicBlock+ '}'
  public static boolean FunctionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<function body>");
    r = consumeToken(b, "{");
    r = r && FunctionBody_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, FUNCTION_BODY, r, false, null);
    return r;
  }

  // BasicBlock+
  private static boolean FunctionBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BasicBlock(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!BasicBlock(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionBody_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Linkage?
  //                         Visibility?
  //                         DllStorageClass?
  //                         CallingConvention?
  //                         ReturnAttribute*
  //                         Type
  //                         GLOBAL_IDENTIFIER
  //                         '(' ParameterList? ')'
  //                         unnamed_addr?
  //                         FunctionAttribute*
  //                         Section?
  //                         Comdat?
  //                         Alignment?
  //                         (gc  STRING)?
  //                         (prefix TypedValue)?
  //                         (prologue TypedValue)?
  //                         (personality TypedValue)?
  //                         (METADATA_IDENTIFIER METADATA_IDENTIFIER)*
  public static boolean FunctionHeader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<function header>");
    r = FunctionHeader_0(b, l + 1);
    r = r && FunctionHeader_1(b, l + 1);
    r = r && FunctionHeader_2(b, l + 1);
    r = r && FunctionHeader_3(b, l + 1);
    r = r && FunctionHeader_4(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, GLOBAL_IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && FunctionHeader_8(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && FunctionHeader_10(b, l + 1);
    r = r && FunctionHeader_11(b, l + 1);
    r = r && FunctionHeader_12(b, l + 1);
    r = r && FunctionHeader_13(b, l + 1);
    r = r && FunctionHeader_14(b, l + 1);
    r = r && FunctionHeader_15(b, l + 1);
    r = r && FunctionHeader_16(b, l + 1);
    r = r && FunctionHeader_17(b, l + 1);
    r = r && FunctionHeader_18(b, l + 1);
    r = r && FunctionHeader_19(b, l + 1);
    exit_section_(b, l, m, FUNCTION_HEADER, r, false, null);
    return r;
  }

  // Linkage?
  private static boolean FunctionHeader_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_0")) return false;
    Linkage(b, l + 1);
    return true;
  }

  // Visibility?
  private static boolean FunctionHeader_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_1")) return false;
    Visibility(b, l + 1);
    return true;
  }

  // DllStorageClass?
  private static boolean FunctionHeader_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_2")) return false;
    DllStorageClass(b, l + 1);
    return true;
  }

  // CallingConvention?
  private static boolean FunctionHeader_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_3")) return false;
    CallingConvention(b, l + 1);
    return true;
  }

  // ReturnAttribute*
  private static boolean FunctionHeader_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ReturnAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionHeader_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ParameterList?
  private static boolean FunctionHeader_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_8")) return false;
    ParameterList(b, l + 1);
    return true;
  }

  // unnamed_addr?
  private static boolean FunctionHeader_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_10")) return false;
    consumeToken(b, UNNAMED_ADDR);
    return true;
  }

  // FunctionAttribute*
  private static boolean FunctionHeader_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_11")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionHeader_11", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // Section?
  private static boolean FunctionHeader_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_12")) return false;
    Section(b, l + 1);
    return true;
  }

  // Comdat?
  private static boolean FunctionHeader_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_13")) return false;
    Comdat(b, l + 1);
    return true;
  }

  // Alignment?
  private static boolean FunctionHeader_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_14")) return false;
    Alignment(b, l + 1);
    return true;
  }

  // (gc  STRING)?
  private static boolean FunctionHeader_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_15")) return false;
    FunctionHeader_15_0(b, l + 1);
    return true;
  }

  // gc  STRING
  private static boolean FunctionHeader_15_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_15_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GC, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // (prefix TypedValue)?
  private static boolean FunctionHeader_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_16")) return false;
    FunctionHeader_16_0(b, l + 1);
    return true;
  }

  // prefix TypedValue
  private static boolean FunctionHeader_16_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_16_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PREFIX);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (prologue TypedValue)?
  private static boolean FunctionHeader_17(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_17")) return false;
    FunctionHeader_17_0(b, l + 1);
    return true;
  }

  // prologue TypedValue
  private static boolean FunctionHeader_17_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_17_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROLOGUE);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (personality TypedValue)?
  private static boolean FunctionHeader_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_18")) return false;
    FunctionHeader_18_0(b, l + 1);
    return true;
  }

  // personality TypedValue
  private static boolean FunctionHeader_18_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_18_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PERSONALITY);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (METADATA_IDENTIFIER METADATA_IDENTIFIER)*
  private static boolean FunctionHeader_19(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_19")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionHeader_19_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionHeader_19", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // METADATA_IDENTIFIER METADATA_IDENTIFIER
  private static boolean FunctionHeader_19_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_19_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, METADATA_IDENTIFIER, METADATA_IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTERGER_LITERAL
  //                     |   METADATA_IDENTIFIER
  public static boolean Index(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Index")) return false;
    if (!nextTokenIs(b, "<index>", INTERGER_LITERAL, METADATA_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<index>");
    r = consumeToken(b, INTERGER_LITERAL);
    if (!r) r = consumeToken(b, METADATA_IDENTIFIER);
    exit_section_(b, l, m, INDEX, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ret TypedValue
  //                     |   ret void
  //                     |   br TypedValue
  //                     |   br TypedValue ',' TypedValue ',' TypedValue
  //                     |   switch TypedValue ',' TypedValue '['  (TypedValue',' TypedValue)* ']'
  //                     |   indirectbr TypedValue ',' '[' TypedValue (',' TypedValue)* ']'
  //                     |   invoke
  //                             CallingConvention?
  //                             ReturnAttribute*
  //                             Type
  //                             GLOBAL_IDENTIFIER
  //                             '(' ArgumentList? ')'
  //                             FunctionAttribute*
  //                             ('[' OperandBundle (',' OperandBundle)* ']')?
  //                             to TypedValue
  //                             unwind TypedValue
  //                     |   resume TypedValue
  //                     |   cleanupret from Value unwind to caller
  //                     |   cleanupret from Value unwind TypedValue
  //                     |   catchret from Value to TypedValue
  //                     |   catchswitch within Value '[' TypedValue (',' TypedValue)* ']' unwind to caller
  //                     |   catchswitch within Value '[' TypedValue (',' TypedValue)* ']' unwind TypedValue
  //                     |   catchpad within Value '[' (TypedValue (',' TypedValue)*)? ']'
  //                     |   cleanuppad within Value '[' (TypedValue (',' TypedValue)*)? ']'
  //                     |   add nuw? nsw? Type Value ',' Value
  //                     |   sub nuw? nsw? Type Value ',' Value
  //                     |   mul nuw? nsw? Type Value ',' Value
  //                     |   shl nuw? nsw? Type Value ',' Value
  //                     |   fadd FastMathsFlag* Type Value ',' Value
  //                     |   fsub FastMathsFlag* Type Value ',' Value
  //                     |   fmul FastMathsFlag* Type Value ',' Value
  //                     |   fdiv FastMathsFlag* Type Value ',' Value
  //                     |   frem FastMathsFlag* Type Value ',' Value
  //                     |   sdiv exact? Type Value ',' Value
  //                     |   udiv exact? Type Value ',' Value
  //                     |   lshr exact? Type Value ',' Value
  //                     |   ashr exact? Type Value ',' Value
  //                     |   urem Type Value ',' Value
  //                     |   srem Type Value ',' Value
  //                     |   and Type Value ',' Value
  //                     |   or Type Value ',' Value
  //                     |   xor Type Value ',' Value
  //                     |   icmp IntPredicate Type Value ',' Value
  //                     |   fcmp FastMathsFlag* FPPredicate Type Value ',' Value
  //                     |   trunc TypedValue to Type
  //                     |   zext TypedValue to Type
  //                     |   sext TypedValue to Type
  //                     |   fptrunc TypedValue to Type
  //                     |   fpext TypedValue to Type
  //                     |   bitcast TypedValue to Type
  //                     |   addrspacecast TypedValue to Type
  //                     |   uitofp TypedValue to Type
  //                     |   sitofp TypedValue to Type
  //                     |   fptoui TypedValue to Type
  //                     |   fptosi TypedValue to Type
  //                     |   inttoptr TypedValue to Type
  //                     |   ptrtoint TypedValue to Type
  //                     |   select TypedValue ',' TypedValue ','TypedValue
  //                     |   va_arg TypedValue ',' Type
  //                     |   extractelement TypedValue ',' TypedValue
  //                     |   insertelement TypedValue ',' TypedValue ',' TypedValue
  //                     |   shufflevector TypedValue ',' TypedValue ',' TypedValue
  //                     |   phi Type '[' Value ',' Value ']' (',' '[' Value ',' Value ']')*
  //                     |   landingpad Type cleanup Clause*
  //                     |   landingpad Type Clause+
  //                     |   (tail| musttail|notail)? call FastMathsFlag* CallingConvention?
  //                             ReturnAttribute* Type Value '(' ArgumentList? ')'
  //                             FunctionAttribute* OperandBundle*
  //                     |   alloca inalloca? Type (',' TypedValue)? (',' align INTERGER_LITERAL)?
  //                     |   load volatile? Type ',' TypedValue (',' align INTERGER_LITERAL)?
  //                     |   load atomic volatile? Type ',' TypedValue singlethread? AtomicOrdering
  //                             (',' align INTERGER_LITERAL)?
  //                     |   store volatile? TypedValue ',' TypedValue (',' align INTERGER_LITERAL)?
  //                     |   store atomic volatile? TypedValue ',' TypedValue singlethread? AtomicOrdering
  //                             (',' align INTERGER_LITERAL)?
  //                     |   cmpxchg weak? volatile? TypedValue ',' TypedValue ',' TypedValue singlethread?
  //                             AtomicOrdering AtomicOrdering
  //                     |   atomicrmw volatile? Operation TypedValue ',' TypedValue singlethread? AtomicOrdering
  //                     |   fence singlethread? AtomicOrdering
  //                     |   getelementptr inbounds? Type ',' TypedValue (',' TypedValue)*
  //                     |   getelementptr inbounds? TypedValue (',' TypedValue)*
  //                     |   extractvalue TypedValue (',' Index)+
  //                     |   insertvalue TypedValue ',' TypedValue(',' Index)+
  //                     |   unreachable
  public static boolean Instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<instruction>");
    r = Instruction_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, RET, VOID);
    if (!r) r = Instruction_2(b, l + 1);
    if (!r) r = Instruction_3(b, l + 1);
    if (!r) r = Instruction_4(b, l + 1);
    if (!r) r = Instruction_5(b, l + 1);
    if (!r) r = Instruction_6(b, l + 1);
    if (!r) r = Instruction_7(b, l + 1);
    if (!r) r = Instruction_8(b, l + 1);
    if (!r) r = Instruction_9(b, l + 1);
    if (!r) r = Instruction_10(b, l + 1);
    if (!r) r = Instruction_11(b, l + 1);
    if (!r) r = Instruction_12(b, l + 1);
    if (!r) r = Instruction_13(b, l + 1);
    if (!r) r = Instruction_14(b, l + 1);
    if (!r) r = Instruction_15(b, l + 1);
    if (!r) r = Instruction_16(b, l + 1);
    if (!r) r = Instruction_17(b, l + 1);
    if (!r) r = Instruction_18(b, l + 1);
    if (!r) r = Instruction_19(b, l + 1);
    if (!r) r = Instruction_20(b, l + 1);
    if (!r) r = Instruction_21(b, l + 1);
    if (!r) r = Instruction_22(b, l + 1);
    if (!r) r = Instruction_23(b, l + 1);
    if (!r) r = Instruction_24(b, l + 1);
    if (!r) r = Instruction_25(b, l + 1);
    if (!r) r = Instruction_26(b, l + 1);
    if (!r) r = Instruction_27(b, l + 1);
    if (!r) r = Instruction_28(b, l + 1);
    if (!r) r = Instruction_29(b, l + 1);
    if (!r) r = Instruction_30(b, l + 1);
    if (!r) r = Instruction_31(b, l + 1);
    if (!r) r = Instruction_32(b, l + 1);
    if (!r) r = Instruction_33(b, l + 1);
    if (!r) r = Instruction_34(b, l + 1);
    if (!r) r = Instruction_35(b, l + 1);
    if (!r) r = Instruction_36(b, l + 1);
    if (!r) r = Instruction_37(b, l + 1);
    if (!r) r = Instruction_38(b, l + 1);
    if (!r) r = Instruction_39(b, l + 1);
    if (!r) r = Instruction_40(b, l + 1);
    if (!r) r = Instruction_41(b, l + 1);
    if (!r) r = Instruction_42(b, l + 1);
    if (!r) r = Instruction_43(b, l + 1);
    if (!r) r = Instruction_44(b, l + 1);
    if (!r) r = Instruction_45(b, l + 1);
    if (!r) r = Instruction_46(b, l + 1);
    if (!r) r = Instruction_47(b, l + 1);
    if (!r) r = Instruction_48(b, l + 1);
    if (!r) r = Instruction_49(b, l + 1);
    if (!r) r = Instruction_50(b, l + 1);
    if (!r) r = Instruction_51(b, l + 1);
    if (!r) r = Instruction_52(b, l + 1);
    if (!r) r = Instruction_53(b, l + 1);
    if (!r) r = Instruction_54(b, l + 1);
    if (!r) r = Instruction_55(b, l + 1);
    if (!r) r = Instruction_56(b, l + 1);
    if (!r) r = Instruction_57(b, l + 1);
    if (!r) r = Instruction_58(b, l + 1);
    if (!r) r = Instruction_59(b, l + 1);
    if (!r) r = Instruction_60(b, l + 1);
    if (!r) r = Instruction_61(b, l + 1);
    if (!r) r = Instruction_62(b, l + 1);
    if (!r) r = Instruction_63(b, l + 1);
    if (!r) r = Instruction_64(b, l + 1);
    if (!r) r = Instruction_65(b, l + 1);
    if (!r) r = Instruction_66(b, l + 1);
    if (!r) r = Instruction_67(b, l + 1);
    if (!r) r = Instruction_68(b, l + 1);
    if (!r) r = consumeToken(b, UNREACHABLE);
    exit_section_(b, l, m, INSTRUCTION, r, false, null);
    return r;
  }

  // ret TypedValue
  private static boolean Instruction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RET);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // br TypedValue
  private static boolean Instruction_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BR);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // br TypedValue ',' TypedValue ',' TypedValue
  private static boolean Instruction_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BR);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // switch TypedValue ',' TypedValue '['  (TypedValue',' TypedValue)* ']'
  private static boolean Instruction_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "[");
    r = r && Instruction_4_5(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (TypedValue',' TypedValue)*
  private static boolean Instruction_4_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_4_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_4_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_4_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // TypedValue',' TypedValue
  private static boolean Instruction_4_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_4_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // indirectbr TypedValue ',' '[' TypedValue (',' TypedValue)* ']'
  private static boolean Instruction_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDIRECTBR);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && consumeToken(b, "[");
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_5_5(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Instruction_5_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_5_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_5_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_5_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_5_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_5_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // invoke
  //                             CallingConvention?
  //                             ReturnAttribute*
  //                             Type
  //                             GLOBAL_IDENTIFIER
  //                             '(' ArgumentList? ')'
  //                             FunctionAttribute*
  //                             ('[' OperandBundle (',' OperandBundle)* ']')?
  //                             to TypedValue
  //                             unwind TypedValue
  private static boolean Instruction_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INVOKE);
    r = r && Instruction_6_1(b, l + 1);
    r = r && Instruction_6_2(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, GLOBAL_IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && Instruction_6_6(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && Instruction_6_8(b, l + 1);
    r = r && Instruction_6_9(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, UNWIND);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CallingConvention?
  private static boolean Instruction_6_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_1")) return false;
    CallingConvention(b, l + 1);
    return true;
  }

  // ReturnAttribute*
  private static boolean Instruction_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ReturnAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_6_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ArgumentList?
  private static boolean Instruction_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_6")) return false;
    ArgumentList(b, l + 1);
    return true;
  }

  // FunctionAttribute*
  private static boolean Instruction_6_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_8")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_6_8", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ('[' OperandBundle (',' OperandBundle)* ']')?
  private static boolean Instruction_6_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_9")) return false;
    Instruction_6_9_0(b, l + 1);
    return true;
  }

  // '[' OperandBundle (',' OperandBundle)* ']'
  private static boolean Instruction_6_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && OperandBundle(b, l + 1);
    r = r && Instruction_6_9_0_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' OperandBundle)*
  private static boolean Instruction_6_9_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_9_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_6_9_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_6_9_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' OperandBundle
  private static boolean Instruction_6_9_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_6_9_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && OperandBundle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // resume TypedValue
  private static boolean Instruction_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RESUME);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // cleanupret from Value unwind to caller
  private static boolean Instruction_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CLEANUPRET, FROM);
    r = r && Value(b, l + 1);
    r = r && consumeTokens(b, 0, UNWIND, TO, CALLER);
    exit_section_(b, m, null, r);
    return r;
  }

  // cleanupret from Value unwind TypedValue
  private static boolean Instruction_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CLEANUPRET, FROM);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, UNWIND);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // catchret from Value to TypedValue
  private static boolean Instruction_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CATCHRET, FROM);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // catchswitch within Value '[' TypedValue (',' TypedValue)* ']' unwind to caller
  private static boolean Instruction_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CATCHSWITCH, WITHIN);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, "[");
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_11_5(b, l + 1);
    r = r && consumeToken(b, "]");
    r = r && consumeTokens(b, 0, UNWIND, TO, CALLER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Instruction_11_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_11_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_11_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_11_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_11_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_11_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // catchswitch within Value '[' TypedValue (',' TypedValue)* ']' unwind TypedValue
  private static boolean Instruction_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CATCHSWITCH, WITHIN);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, "[");
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_12_5(b, l + 1);
    r = r && consumeToken(b, "]");
    r = r && consumeToken(b, UNWIND);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Instruction_12_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_12_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_12_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_12_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_12_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_12_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // catchpad within Value '[' (TypedValue (',' TypedValue)*)? ']'
  private static boolean Instruction_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CATCHPAD, WITHIN);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, "[");
    r = r && Instruction_13_4(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (TypedValue (',' TypedValue)*)?
  private static boolean Instruction_13_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_13_4")) return false;
    Instruction_13_4_0(b, l + 1);
    return true;
  }

  // TypedValue (',' TypedValue)*
  private static boolean Instruction_13_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_13_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypedValue(b, l + 1);
    r = r && Instruction_13_4_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Instruction_13_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_13_4_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_13_4_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_13_4_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_13_4_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_13_4_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // cleanuppad within Value '[' (TypedValue (',' TypedValue)*)? ']'
  private static boolean Instruction_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CLEANUPPAD, WITHIN);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, "[");
    r = r && Instruction_14_4(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (TypedValue (',' TypedValue)*)?
  private static boolean Instruction_14_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_14_4")) return false;
    Instruction_14_4_0(b, l + 1);
    return true;
  }

  // TypedValue (',' TypedValue)*
  private static boolean Instruction_14_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_14_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypedValue(b, l + 1);
    r = r && Instruction_14_4_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Instruction_14_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_14_4_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_14_4_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_14_4_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_14_4_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_14_4_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // add nuw? nsw? Type Value ',' Value
  private static boolean Instruction_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ADD);
    r = r && Instruction_15_1(b, l + 1);
    r = r && Instruction_15_2(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Instruction_15_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_15_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Instruction_15_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_15_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // sub nuw? nsw? Type Value ',' Value
  private static boolean Instruction_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUB);
    r = r && Instruction_16_1(b, l + 1);
    r = r && Instruction_16_2(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Instruction_16_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_16_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Instruction_16_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_16_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // mul nuw? nsw? Type Value ',' Value
  private static boolean Instruction_17(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_17")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    r = r && Instruction_17_1(b, l + 1);
    r = r && Instruction_17_2(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Instruction_17_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_17_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Instruction_17_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_17_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // shl nuw? nsw? Type Value ',' Value
  private static boolean Instruction_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHL);
    r = r && Instruction_18_1(b, l + 1);
    r = r && Instruction_18_2(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Instruction_18_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_18_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Instruction_18_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_18_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // fadd FastMathsFlag* Type Value ',' Value
  private static boolean Instruction_19(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_19")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FADD);
    r = r && Instruction_19_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FastMathsFlag*
  private static boolean Instruction_19_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_19_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FastMathsFlag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_19_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // fsub FastMathsFlag* Type Value ',' Value
  private static boolean Instruction_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FSUB);
    r = r && Instruction_20_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FastMathsFlag*
  private static boolean Instruction_20_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_20_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FastMathsFlag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_20_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // fmul FastMathsFlag* Type Value ',' Value
  private static boolean Instruction_21(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_21")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FMUL);
    r = r && Instruction_21_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FastMathsFlag*
  private static boolean Instruction_21_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_21_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FastMathsFlag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_21_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // fdiv FastMathsFlag* Type Value ',' Value
  private static boolean Instruction_22(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_22")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FDIV);
    r = r && Instruction_22_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FastMathsFlag*
  private static boolean Instruction_22_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_22_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FastMathsFlag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_22_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // frem FastMathsFlag* Type Value ',' Value
  private static boolean Instruction_23(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_23")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FREM);
    r = r && Instruction_23_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FastMathsFlag*
  private static boolean Instruction_23_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_23_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FastMathsFlag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_23_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // sdiv exact? Type Value ',' Value
  private static boolean Instruction_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_24")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SDIV);
    r = r && Instruction_24_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exact?
  private static boolean Instruction_24_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_24_1")) return false;
    consumeToken(b, EXACT);
    return true;
  }

  // udiv exact? Type Value ',' Value
  private static boolean Instruction_25(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_25")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UDIV);
    r = r && Instruction_25_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exact?
  private static boolean Instruction_25_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_25_1")) return false;
    consumeToken(b, EXACT);
    return true;
  }

  // lshr exact? Type Value ',' Value
  private static boolean Instruction_26(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_26")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSHR);
    r = r && Instruction_26_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exact?
  private static boolean Instruction_26_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_26_1")) return false;
    consumeToken(b, EXACT);
    return true;
  }

  // ashr exact? Type Value ',' Value
  private static boolean Instruction_27(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_27")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASHR);
    r = r && Instruction_27_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exact?
  private static boolean Instruction_27_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_27_1")) return false;
    consumeToken(b, EXACT);
    return true;
  }

  // urem Type Value ',' Value
  private static boolean Instruction_28(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_28")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UREM);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // srem Type Value ',' Value
  private static boolean Instruction_29(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_29")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SREM);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // and Type Value ',' Value
  private static boolean Instruction_30(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_30")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // or Type Value ',' Value
  private static boolean Instruction_31(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_31")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // xor Type Value ',' Value
  private static boolean Instruction_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_32")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, XOR);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // icmp IntPredicate Type Value ',' Value
  private static boolean Instruction_33(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_33")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ICMP);
    r = r && IntPredicate(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fcmp FastMathsFlag* FPPredicate Type Value ',' Value
  private static boolean Instruction_34(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_34")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FCMP);
    r = r && Instruction_34_1(b, l + 1);
    r = r && FPPredicate(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FastMathsFlag*
  private static boolean Instruction_34_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_34_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FastMathsFlag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_34_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // trunc TypedValue to Type
  private static boolean Instruction_35(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_35")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUNC);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // zext TypedValue to Type
  private static boolean Instruction_36(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_36")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ZEXT);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sext TypedValue to Type
  private static boolean Instruction_37(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_37")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEXT);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fptrunc TypedValue to Type
  private static boolean Instruction_38(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_38")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPTRUNC);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fpext TypedValue to Type
  private static boolean Instruction_39(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_39")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPEXT);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // bitcast TypedValue to Type
  private static boolean Instruction_40(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_40")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITCAST);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // addrspacecast TypedValue to Type
  private static boolean Instruction_41(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_41")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ADDRSPACECAST);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // uitofp TypedValue to Type
  private static boolean Instruction_42(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_42")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UITOFP);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sitofp TypedValue to Type
  private static boolean Instruction_43(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_43")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SITOFP);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fptoui TypedValue to Type
  private static boolean Instruction_44(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_44")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPTOUI);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fptosi TypedValue to Type
  private static boolean Instruction_45(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_45")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPTOSI);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inttoptr TypedValue to Type
  private static boolean Instruction_46(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_46")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTTOPTR);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ptrtoint TypedValue to Type
  private static boolean Instruction_47(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_47")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PTRTOINT);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // select TypedValue ',' TypedValue ','TypedValue
  private static boolean Instruction_48(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_48")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SELECT);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // va_arg TypedValue ',' Type
  private static boolean Instruction_49(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_49")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VA_ARG);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // extractelement TypedValue ',' TypedValue
  private static boolean Instruction_50(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_50")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTRACTELEMENT);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // insertelement TypedValue ',' TypedValue ',' TypedValue
  private static boolean Instruction_51(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_51")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INSERTELEMENT);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shufflevector TypedValue ',' TypedValue ',' TypedValue
  private static boolean Instruction_52(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_52")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHUFFLEVECTOR);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // phi Type '[' Value ',' Value ']' (',' '[' Value ',' Value ']')*
  private static boolean Instruction_53(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_53")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PHI);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, "[");
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, "]");
    r = r && Instruction_53_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' '[' Value ',' Value ']')*
  private static boolean Instruction_53_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_53_7")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_53_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_53_7", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' '[' Value ',' Value ']'
  private static boolean Instruction_53_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_53_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeToken(b, "[");
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // landingpad Type cleanup Clause*
  private static boolean Instruction_54(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_54")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANDINGPAD);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, CLEANUP);
    r = r && Instruction_54_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Clause*
  private static boolean Instruction_54_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_54_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_54_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // landingpad Type Clause+
  private static boolean Instruction_55(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_55")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANDINGPAD);
    r = r && Type(b, l + 1, -1);
    r = r && Instruction_55_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Clause+
  private static boolean Instruction_55_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_55_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Clause(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!Clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_55_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (tail| musttail|notail)? call FastMathsFlag* CallingConvention?
  //                             ReturnAttribute* Type Value '(' ArgumentList? ')'
  //                             FunctionAttribute* OperandBundle*
  private static boolean Instruction_56(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Instruction_56_0(b, l + 1);
    r = r && consumeToken(b, CALL);
    r = r && Instruction_56_2(b, l + 1);
    r = r && Instruction_56_3(b, l + 1);
    r = r && Instruction_56_4(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && Instruction_56_8(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && Instruction_56_10(b, l + 1);
    r = r && Instruction_56_11(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (tail| musttail|notail)?
  private static boolean Instruction_56_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_0")) return false;
    Instruction_56_0_0(b, l + 1);
    return true;
  }

  // tail| musttail|notail
  private static boolean Instruction_56_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TAIL);
    if (!r) r = consumeToken(b, MUSTTAIL);
    if (!r) r = consumeToken(b, NOTAIL);
    exit_section_(b, m, null, r);
    return r;
  }

  // FastMathsFlag*
  private static boolean Instruction_56_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FastMathsFlag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_56_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // CallingConvention?
  private static boolean Instruction_56_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_3")) return false;
    CallingConvention(b, l + 1);
    return true;
  }

  // ReturnAttribute*
  private static boolean Instruction_56_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ReturnAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_56_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ArgumentList?
  private static boolean Instruction_56_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_8")) return false;
    ArgumentList(b, l + 1);
    return true;
  }

  // FunctionAttribute*
  private static boolean Instruction_56_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_10")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_56_10", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // OperandBundle*
  private static boolean Instruction_56_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_56_11")) return false;
    int c = current_position_(b);
    while (true) {
      if (!OperandBundle(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_56_11", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // alloca inalloca? Type (',' TypedValue)? (',' align INTERGER_LITERAL)?
  private static boolean Instruction_57(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_57")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALLOCA);
    r = r && Instruction_57_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && Instruction_57_3(b, l + 1);
    r = r && Instruction_57_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inalloca?
  private static boolean Instruction_57_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_57_1")) return false;
    consumeToken(b, INALLOCA);
    return true;
  }

  // (',' TypedValue)?
  private static boolean Instruction_57_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_57_3")) return false;
    Instruction_57_3_0(b, l + 1);
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_57_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_57_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' align INTERGER_LITERAL)?
  private static boolean Instruction_57_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_57_4")) return false;
    Instruction_57_4_0(b, l + 1);
    return true;
  }

  // ',' align INTERGER_LITERAL
  private static boolean Instruction_57_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_57_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeTokens(b, 0, ALIGN, INTERGER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // load volatile? Type ',' TypedValue (',' align INTERGER_LITERAL)?
  private static boolean Instruction_58(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_58")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOAD);
    r = r && Instruction_58_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_58_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // volatile?
  private static boolean Instruction_58_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_58_1")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  // (',' align INTERGER_LITERAL)?
  private static boolean Instruction_58_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_58_5")) return false;
    Instruction_58_5_0(b, l + 1);
    return true;
  }

  // ',' align INTERGER_LITERAL
  private static boolean Instruction_58_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_58_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeTokens(b, 0, ALIGN, INTERGER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // load atomic volatile? Type ',' TypedValue singlethread? AtomicOrdering
  //                             (',' align INTERGER_LITERAL)?
  private static boolean Instruction_59(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_59")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LOAD, ATOMIC);
    r = r && Instruction_59_2(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_59_6(b, l + 1);
    r = r && AtomicOrdering(b, l + 1);
    r = r && Instruction_59_8(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // volatile?
  private static boolean Instruction_59_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_59_2")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  // singlethread?
  private static boolean Instruction_59_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_59_6")) return false;
    consumeToken(b, SINGLETHREAD);
    return true;
  }

  // (',' align INTERGER_LITERAL)?
  private static boolean Instruction_59_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_59_8")) return false;
    Instruction_59_8_0(b, l + 1);
    return true;
  }

  // ',' align INTERGER_LITERAL
  private static boolean Instruction_59_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_59_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeTokens(b, 0, ALIGN, INTERGER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // store volatile? TypedValue ',' TypedValue (',' align INTERGER_LITERAL)?
  private static boolean Instruction_60(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_60")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STORE);
    r = r && Instruction_60_1(b, l + 1);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_60_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // volatile?
  private static boolean Instruction_60_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_60_1")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  // (',' align INTERGER_LITERAL)?
  private static boolean Instruction_60_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_60_5")) return false;
    Instruction_60_5_0(b, l + 1);
    return true;
  }

  // ',' align INTERGER_LITERAL
  private static boolean Instruction_60_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_60_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeTokens(b, 0, ALIGN, INTERGER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // store atomic volatile? TypedValue ',' TypedValue singlethread? AtomicOrdering
  //                             (',' align INTERGER_LITERAL)?
  private static boolean Instruction_61(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_61")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STORE, ATOMIC);
    r = r && Instruction_61_2(b, l + 1);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_61_6(b, l + 1);
    r = r && AtomicOrdering(b, l + 1);
    r = r && Instruction_61_8(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // volatile?
  private static boolean Instruction_61_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_61_2")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  // singlethread?
  private static boolean Instruction_61_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_61_6")) return false;
    consumeToken(b, SINGLETHREAD);
    return true;
  }

  // (',' align INTERGER_LITERAL)?
  private static boolean Instruction_61_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_61_8")) return false;
    Instruction_61_8_0(b, l + 1);
    return true;
  }

  // ',' align INTERGER_LITERAL
  private static boolean Instruction_61_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_61_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeTokens(b, 0, ALIGN, INTERGER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // cmpxchg weak? volatile? TypedValue ',' TypedValue ',' TypedValue singlethread?
  //                             AtomicOrdering AtomicOrdering
  private static boolean Instruction_62(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_62")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CMPXCHG);
    r = r && Instruction_62_1(b, l + 1);
    r = r && Instruction_62_2(b, l + 1);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_62_8(b, l + 1);
    r = r && AtomicOrdering(b, l + 1);
    r = r && AtomicOrdering(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // weak?
  private static boolean Instruction_62_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_62_1")) return false;
    consumeToken(b, WEAK);
    return true;
  }

  // volatile?
  private static boolean Instruction_62_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_62_2")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  // singlethread?
  private static boolean Instruction_62_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_62_8")) return false;
    consumeToken(b, SINGLETHREAD);
    return true;
  }

  // atomicrmw volatile? Operation TypedValue ',' TypedValue singlethread? AtomicOrdering
  private static boolean Instruction_63(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_63")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATOMICRMW);
    r = r && Instruction_63_1(b, l + 1);
    r = r && Operation(b, l + 1);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_63_6(b, l + 1);
    r = r && AtomicOrdering(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // volatile?
  private static boolean Instruction_63_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_63_1")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  // singlethread?
  private static boolean Instruction_63_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_63_6")) return false;
    consumeToken(b, SINGLETHREAD);
    return true;
  }

  // fence singlethread? AtomicOrdering
  private static boolean Instruction_64(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_64")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FENCE);
    r = r && Instruction_64_1(b, l + 1);
    r = r && AtomicOrdering(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // singlethread?
  private static boolean Instruction_64_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_64_1")) return false;
    consumeToken(b, SINGLETHREAD);
    return true;
  }

  // getelementptr inbounds? Type ',' TypedValue (',' TypedValue)*
  private static boolean Instruction_65(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_65")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GETELEMENTPTR);
    r = r && Instruction_65_1(b, l + 1);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_65_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inbounds?
  private static boolean Instruction_65_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_65_1")) return false;
    consumeToken(b, INBOUNDS);
    return true;
  }

  // (',' TypedValue)*
  private static boolean Instruction_65_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_65_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_65_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_65_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_65_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_65_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // getelementptr inbounds? TypedValue (',' TypedValue)*
  private static boolean Instruction_66(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_66")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GETELEMENTPTR);
    r = r && Instruction_66_1(b, l + 1);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_66_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inbounds?
  private static boolean Instruction_66_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_66_1")) return false;
    consumeToken(b, INBOUNDS);
    return true;
  }

  // (',' TypedValue)*
  private static boolean Instruction_66_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_66_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Instruction_66_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_66_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Instruction_66_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_66_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // extractvalue TypedValue (',' Index)+
  private static boolean Instruction_67(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_67")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTRACTVALUE);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_67_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Index)+
  private static boolean Instruction_67_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_67_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Instruction_67_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!Instruction_67_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_67_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' Index
  private static boolean Instruction_67_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_67_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Index(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // insertvalue TypedValue ',' TypedValue(',' Index)+
  private static boolean Instruction_68(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_68")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INSERTVALUE);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Instruction_68_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Index)+
  private static boolean Instruction_68_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_68_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Instruction_68_4_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!Instruction_68_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Instruction_68_4", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' Index
  private static boolean Instruction_68_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Instruction_68_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Index(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // eq
  //                     |   ne
  //                     |   ugt
  //                     |   uge
  //                     |   ult
  //                     |   ule
  //                     |   sgt
  //                     |   sge
  //                     |   slt
  //                     |   sle
  public static boolean IntPredicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntPredicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<int predicate>");
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NE);
    if (!r) r = consumeToken(b, UGT);
    if (!r) r = consumeToken(b, UGE);
    if (!r) r = consumeToken(b, ULT);
    if (!r) r = consumeToken(b, ULE);
    if (!r) r = consumeToken(b, SGT);
    if (!r) r = consumeToken(b, SGE);
    if (!r) r = consumeToken(b, SLT);
    if (!r) r = consumeToken(b, SLE);
    exit_section_(b, l, m, INT_PREDICATE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // private
  //                     |   internal
  //                     |   weak_odr
  //                     |   weak
  //                     |   linkonce
  //                     |   linkonce_odr
  //                     |   available_externally
  //                     |   appending
  //                     |   common
  //                     |   extern_weak
  //                     |   external
  public static boolean Linkage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Linkage")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<linkage>");
    r = consumeToken(b, PRIVATE);
    if (!r) r = consumeToken(b, INTERNAL);
    if (!r) r = consumeToken(b, WEAK_ODR);
    if (!r) r = consumeToken(b, WEAK);
    if (!r) r = consumeToken(b, LINKONCE);
    if (!r) r = consumeToken(b, LINKONCE_ODR);
    if (!r) r = consumeToken(b, AVAILABLE_EXTERNALLY);
    if (!r) r = consumeToken(b, APPENDING);
    if (!r) r = consumeToken(b, COMMON);
    if (!r) r = consumeToken(b, EXTERN_WEAK);
    if (!r) r = consumeToken(b, EXTERNAL);
    exit_section_(b, l, m, LINKAGE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // METADATA_IDENTIFIER
  //                     |   METADATA_STRING
  //                     |   Value
  //                     |   TypedValue
  //                     |   '!{' (Metadata (',' Metadata)*)? '}'
  public static boolean Metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<metadata>");
    r = consumeToken(b, METADATA_IDENTIFIER);
    if (!r) r = consumeToken(b, METADATA_STRING);
    if (!r) r = Value(b, l + 1);
    if (!r) r = TypedValue(b, l + 1);
    if (!r) r = Metadata_4(b, l + 1);
    exit_section_(b, l, m, METADATA, r, false, null);
    return r;
  }

  // '!{' (Metadata (',' Metadata)*)? '}'
  private static boolean Metadata_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METADATA_LEFT_BRACE);
    r = r && Metadata_4_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (Metadata (',' Metadata)*)?
  private static boolean Metadata_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_4_1")) return false;
    Metadata_4_1_0(b, l + 1);
    return true;
  }

  // Metadata (',' Metadata)*
  private static boolean Metadata_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Metadata(b, l + 1);
    r = r && Metadata_4_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Metadata)*
  private static boolean Metadata_4_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_4_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Metadata_4_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Metadata_4_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Metadata
  private static boolean Metadata_4_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_4_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Metadata(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Entity*
  static boolean Module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Module")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Entity(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Module", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // STRING '(' TypedValue (',' TypedValue) * ')'
  public static boolean OperandBundle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperandBundle")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && OperandBundle_3(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, OPERAND_BUNDLE, r);
    return r;
  }

  // (',' TypedValue) *
  private static boolean OperandBundle_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperandBundle_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!OperandBundle_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OperandBundle_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean OperandBundle_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperandBundle_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // xchg
  //                     |   add
  //                     |   sub
  //                     |   and
  //                     |   nand
  //                     |   or
  //                     |   xor
  //                     |   max
  //                     |   min
  //                     |   umax
  //                     |   umin
  public static boolean Operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<operation>");
    r = consumeToken(b, XCHG);
    if (!r) r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, NAND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, XOR);
    if (!r) r = consumeToken(b, MAX);
    if (!r) r = consumeToken(b, MIN);
    if (!r) r = consumeToken(b, UMAX);
    if (!r) r = consumeToken(b, UMIN);
    exit_section_(b, l, m, OPERATION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Type ParameterAttribute* LOCAL_IDENTIFIER?
  //                     |   '...'
  public static boolean Parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<parameter>");
    r = Parameter_0(b, l + 1);
    if (!r) r = consumeToken(b, "...");
    exit_section_(b, l, m, PARAMETER, r, false, null);
    return r;
  }

  // Type ParameterAttribute* LOCAL_IDENTIFIER?
  private static boolean Parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1, -1);
    r = r && Parameter_0_1(b, l + 1);
    r = r && Parameter_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParameterAttribute*
  private static boolean Parameter_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ParameterAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Parameter_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // LOCAL_IDENTIFIER?
  private static boolean Parameter_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter_0_2")) return false;
    consumeToken(b, LOCAL_IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // align INTERGER_LITERAL
  //                     |   byval
  //                     |   dereferenceable '(' INTERGER_LITERAL ')'
  //                     |   dereferenceable_or_null '(' INTERGER_LITERAL ')'
  //                     |   inalloca
  //                     |   inreg
  //                     |   nest
  //                     |   noalias
  //                     |   nocapture
  //                     |   nonnull
  //                     |   readnone
  //                     |   readonly
  //                     |   returned
  //                     |   signext
  //                     |   sret
  //                     |   zeroext
  //                     |    STRING
  public static boolean ParameterAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterAttribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<parameter attribute>");
    r = parseTokens(b, 0, ALIGN, INTERGER_LITERAL);
    if (!r) r = consumeToken(b, BYVAL);
    if (!r) r = ParameterAttribute_2(b, l + 1);
    if (!r) r = ParameterAttribute_3(b, l + 1);
    if (!r) r = consumeToken(b, INALLOCA);
    if (!r) r = consumeToken(b, INREG);
    if (!r) r = consumeToken(b, NEST);
    if (!r) r = consumeToken(b, NOALIAS);
    if (!r) r = consumeToken(b, NOCAPTURE);
    if (!r) r = consumeToken(b, NONNULL);
    if (!r) r = consumeToken(b, READNONE);
    if (!r) r = consumeToken(b, READONLY);
    if (!r) r = consumeToken(b, RETURNED);
    if (!r) r = consumeToken(b, SIGNEXT);
    if (!r) r = consumeToken(b, SRET);
    if (!r) r = consumeToken(b, ZEROEXT);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, PARAMETER_ATTRIBUTE, r, false, null);
    return r;
  }

  // dereferenceable '(' INTERGER_LITERAL ')'
  private static boolean ParameterAttribute_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterAttribute_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEREFERENCEABLE);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // dereferenceable_or_null '(' INTERGER_LITERAL ')'
  private static boolean ParameterAttribute_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterAttribute_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEREFERENCEABLE_OR_NULL);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Parameter (',' Parameter)*
  public static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<parameter list>");
    r = Parameter(b, l + 1);
    r = r && ParameterList_1(b, l + 1);
    exit_section_(b, l, m, PARAMETER_LIST, r, false, null);
    return r;
  }

  // (',' Parameter)*
  private static boolean ParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ParameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Parameter
  private static boolean ParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING
  //                     |   dereferenceable_or_null '(' INTERGER_LITERAL ')'
  //                     |   dereferenceable '(' INTERGER_LITERAL ')'
  //                     |   align INTERGER_LITERAL
  //                     |   inreg
  //                     |   noalias
  //                     |   nonnull
  //                     |   signext
  //                     |   zeroext
  public static boolean ReturnAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnAttribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<return attribute>");
    r = consumeToken(b, STRING);
    if (!r) r = ReturnAttribute_1(b, l + 1);
    if (!r) r = ReturnAttribute_2(b, l + 1);
    if (!r) r = parseTokens(b, 0, ALIGN, INTERGER_LITERAL);
    if (!r) r = consumeToken(b, INREG);
    if (!r) r = consumeToken(b, NOALIAS);
    if (!r) r = consumeToken(b, NONNULL);
    if (!r) r = consumeToken(b, SIGNEXT);
    if (!r) r = consumeToken(b, ZEROEXT);
    exit_section_(b, l, m, RETURN_ATTRIBUTE, r, false, null);
    return r;
  }

  // dereferenceable_or_null '(' INTERGER_LITERAL ')'
  private static boolean ReturnAttribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnAttribute_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEREFERENCEABLE_OR_NULL);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // dereferenceable '(' INTERGER_LITERAL ')'
  private static boolean ReturnAttribute_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnAttribute_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEREFERENCEABLE);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // global
  //                     |   constant
  public static boolean Scope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Scope")) return false;
    if (!nextTokenIs(b, "<scope>", CONSTANT, GLOBAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<scope>");
    r = consumeToken(b, GLOBAL);
    if (!r) r = consumeToken(b, CONSTANT);
    exit_section_(b, l, m, SCOPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'section'  STRING
  public static boolean Section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<section>");
    r = consumeToken(b, "section");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, SECTION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // any
  //                     |   exactmatch
  //                     |   largest
  //                     |   noduplicates
  //                     |   samesize
  public static boolean SelectionKind(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectionKind")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<selection kind>");
    r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, EXACTMATCH);
    if (!r) r = consumeToken(b, LARGEST);
    if (!r) r = consumeToken(b, NODUPLICATES);
    if (!r) r = consumeToken(b, SAMESIZE);
    exit_section_(b, l, m, SELECTION_KIND, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (LOCAL_IDENTIFIER '=')? Instruction (',' METADATA_IDENTIFIER Metadata)*
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<statement>");
    r = Statement_0(b, l + 1);
    r = r && Instruction(b, l + 1);
    r = r && Statement_2(b, l + 1);
    exit_section_(b, l, m, STATEMENT, r, false, null);
    return r;
  }

  // (LOCAL_IDENTIFIER '=')?
  private static boolean Statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_0")) return false;
    Statement_0_0(b, l + 1);
    return true;
  }

  // LOCAL_IDENTIFIER '='
  private static boolean Statement_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL_IDENTIFIER);
    r = r && consumeToken(b, "=");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' METADATA_IDENTIFIER Metadata)*
  private static boolean Statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Statement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Statement_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' METADATA_IDENTIFIER Metadata
  private static boolean Statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeToken(b, METADATA_IDENTIFIER);
    r = r && Metadata(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // localdynamic
  //                     |   initialexec
  //                     |   localexec
  public static boolean ThreadLocalStorage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ThreadLocalStorage")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<thread local storage>");
    r = consumeToken(b, LOCALDYNAMIC);
    if (!r) r = consumeToken(b, INITIALEXEC);
    if (!r) r = consumeToken(b, LOCALEXEC);
    exit_section_(b, l, m, THREAD_LOCAL_STORAGE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Type Value
  public static boolean TypedValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypedValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<typed value>");
    r = Type(b, l + 1, -1);
    r = r && Value(b, l + 1);
    exit_section_(b, l, m, TYPED_VALUE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // GLOBAL_IDENTIFIER
  //                     |   LOCAL_IDENTIFIER
  //                     |   FloatLiteral
  //                     |   INTERGER_LITERAL
  //                     |   CHAR_ARRAY_LITERAL
  //                     |   true
  //                     |   false
  //                     |   null
  //                     |   undef
  //                     |   zeroinitializer
  //                     |   none
  //                     |   '{' TypedValue (',' TypedValue)* '}'
  //                     |   '<' TypedValue (',' TypedValue)* '>'
  //                     |   '[' TypedValue (',' TypedValue)* ']'
  //                     |   asm sideeffect? alignstack? inteldialect?  STRING ','  STRING
  //                     |   blockaddress '(' GLOBAL_IDENTIFIER ',' LOCAL_IDENTIFIER ')'
  //                     |   trunc '(' TypedValue 'to' Type ')'
  //                     |   zext '(' TypedValue 'to' Type ')'
  //                     |   sext '(' TypedValue 'to' Type ')'
  //                     |   fptrunc '(' TypedValue 'to' Type ')'
  //                     |   fpext '(' TypedValue 'to' Type ')'
  //                     |   bitcast '(' TypedValue 'to' Type ')'
  //                     |   addrspacecast '(' TypedValue 'to' Type ')'
  //                     |   uitofp '(' TypedValue 'to' Type ')'
  //                     |   sitofp '(' TypedValue 'to' Type ')'
  //                     |   fptoui '(' TypedValue 'to' Type ')'
  //                     |   inttoptr '(' TypedValue 'to' Type ')'
  //                     |   ptrtoint '(' TypedValue 'to' Type ')'
  //                     |   insertvalue '(' Value ',' Value (',' Index )+ ')'
  //                     |   icmp IntPredicate '(' TypedValue ',' TypedValue ')'
  //                     |   fcmp FPPredicate '(' TypedValue ',' TypedValue ')'
  //                     |   fadd '(' TypedValue ',' TypedValue  ')'
  //                     |   fsub '(' TypedValue ',' TypedValue  ')'
  //                     |   add nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  //                     |   sub nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  //                     |   mul nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  //                     |   shl nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  //                     |   fmul '(' TypedValue ',' TypedValue  ')'
  //                     |   udiv '(' TypedValue ',' TypedValue  ')'
  //                     |   sdiv '(' TypedValue ',' TypedValue  ')'
  //                     |   fdiv '(' TypedValue ',' TypedValue  ')'
  //                     |   urem '(' TypedValue ',' TypedValue  ')'
  //                     |   srem '(' TypedValue ',' TypedValue  ')'
  //                     |   frem '(' TypedValue ',' TypedValue  ')'
  //                     |   lshl '(' TypedValue ',' TypedValue  ')'
  //                     |   ashr '(' TypedValue ',' TypedValue  ')'
  //                     |   and '(' TypedValue ',' TypedValue  ')'
  //                     |   or '(' TypedValue ',' TypedValue  ')'
  //                     |   xor '(' TypedValue ',' TypedValue  ')'
  //                     |   getelementptr inbounds? '(' Type ',' TypedValue (',' TypedValue)* ')'
  //                     |   getelementptr inbounds? '(' TypedValue (',' TypedValue)* ')'
  //                     |   shufflevector '(' TypedValue ',' TypedValue ',' TypedValue ')'
  //                     |   insertelement '(' TypedValue ',' TypedValue ',' TypedValue ')'
  //                     |   extractelement '(' TypedValue ',' TypedValue ')'
  //                     |   select '(' TypedValue ',' TypedValue ','TypedValue ')'
  public static boolean Value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<value>");
    r = consumeToken(b, GLOBAL_IDENTIFIER);
    if (!r) r = consumeToken(b, LOCAL_IDENTIFIER);
    if (!r) r = FloatLiteral(b, l + 1);
    if (!r) r = consumeToken(b, INTERGER_LITERAL);
    if (!r) r = consumeToken(b, CHAR_ARRAY_LITERAL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, UNDEF);
    if (!r) r = consumeToken(b, ZEROINITIALIZER);
    if (!r) r = consumeToken(b, NONE);
    if (!r) r = Value_11(b, l + 1);
    if (!r) r = Value_12(b, l + 1);
    if (!r) r = Value_13(b, l + 1);
    if (!r) r = Value_14(b, l + 1);
    if (!r) r = Value_15(b, l + 1);
    if (!r) r = Value_16(b, l + 1);
    if (!r) r = Value_17(b, l + 1);
    if (!r) r = Value_18(b, l + 1);
    if (!r) r = Value_19(b, l + 1);
    if (!r) r = Value_20(b, l + 1);
    if (!r) r = Value_21(b, l + 1);
    if (!r) r = Value_22(b, l + 1);
    if (!r) r = Value_23(b, l + 1);
    if (!r) r = Value_24(b, l + 1);
    if (!r) r = Value_25(b, l + 1);
    if (!r) r = Value_26(b, l + 1);
    if (!r) r = Value_27(b, l + 1);
    if (!r) r = Value_28(b, l + 1);
    if (!r) r = Value_29(b, l + 1);
    if (!r) r = Value_30(b, l + 1);
    if (!r) r = Value_31(b, l + 1);
    if (!r) r = Value_32(b, l + 1);
    if (!r) r = Value_33(b, l + 1);
    if (!r) r = Value_34(b, l + 1);
    if (!r) r = Value_35(b, l + 1);
    if (!r) r = Value_36(b, l + 1);
    if (!r) r = Value_37(b, l + 1);
    if (!r) r = Value_38(b, l + 1);
    if (!r) r = Value_39(b, l + 1);
    if (!r) r = Value_40(b, l + 1);
    if (!r) r = Value_41(b, l + 1);
    if (!r) r = Value_42(b, l + 1);
    if (!r) r = Value_43(b, l + 1);
    if (!r) r = Value_44(b, l + 1);
    if (!r) r = Value_45(b, l + 1);
    if (!r) r = Value_46(b, l + 1);
    if (!r) r = Value_47(b, l + 1);
    if (!r) r = Value_48(b, l + 1);
    if (!r) r = Value_49(b, l + 1);
    if (!r) r = Value_50(b, l + 1);
    if (!r) r = Value_51(b, l + 1);
    if (!r) r = Value_52(b, l + 1);
    if (!r) r = Value_53(b, l + 1);
    if (!r) r = Value_54(b, l + 1);
    exit_section_(b, l, m, VALUE, r, false, null);
    return r;
  }

  // '{' TypedValue (',' TypedValue)* '}'
  private static boolean Value_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && TypedValue(b, l + 1);
    r = r && Value_11_2(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Value_11_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_11_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Value_11_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Value_11_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Value_11_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_11_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<' TypedValue (',' TypedValue)* '>'
  private static boolean Value_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<");
    r = r && TypedValue(b, l + 1);
    r = r && Value_12_2(b, l + 1);
    r = r && consumeToken(b, ">");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Value_12_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_12_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Value_12_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Value_12_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Value_12_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_12_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' TypedValue (',' TypedValue)* ']'
  private static boolean Value_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && TypedValue(b, l + 1);
    r = r && Value_13_2(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypedValue)*
  private static boolean Value_13_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_13_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Value_13_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Value_13_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Value_13_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_13_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // asm sideeffect? alignstack? inteldialect?  STRING ','  STRING
  private static boolean Value_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASM);
    r = r && Value_14_1(b, l + 1);
    r = r && Value_14_2(b, l + 1);
    r = r && Value_14_3(b, l + 1);
    r = r && consumeToken(b, STRING);
    r = r && consumeToken(b, COMMA);
    r = r && consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // sideeffect?
  private static boolean Value_14_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_14_1")) return false;
    consumeToken(b, SIDEEFFECT);
    return true;
  }

  // alignstack?
  private static boolean Value_14_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_14_2")) return false;
    consumeToken(b, ALIGNSTACK);
    return true;
  }

  // inteldialect?
  private static boolean Value_14_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_14_3")) return false;
    consumeToken(b, INTELDIALECT);
    return true;
  }

  // blockaddress '(' GLOBAL_IDENTIFIER ',' LOCAL_IDENTIFIER ')'
  private static boolean Value_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCKADDRESS);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, GLOBAL_IDENTIFIER);
    r = r && consumeToken(b, COMMA);
    r = r && consumeToken(b, LOCAL_IDENTIFIER);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // trunc '(' TypedValue 'to' Type ')'
  private static boolean Value_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUNC);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // zext '(' TypedValue 'to' Type ')'
  private static boolean Value_17(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_17")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ZEXT);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // sext '(' TypedValue 'to' Type ')'
  private static boolean Value_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEXT);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // fptrunc '(' TypedValue 'to' Type ')'
  private static boolean Value_19(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_19")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPTRUNC);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // fpext '(' TypedValue 'to' Type ')'
  private static boolean Value_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPEXT);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // bitcast '(' TypedValue 'to' Type ')'
  private static boolean Value_21(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_21")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITCAST);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // addrspacecast '(' TypedValue 'to' Type ')'
  private static boolean Value_22(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_22")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ADDRSPACECAST);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // uitofp '(' TypedValue 'to' Type ')'
  private static boolean Value_23(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_23")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UITOFP);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // sitofp '(' TypedValue 'to' Type ')'
  private static boolean Value_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_24")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SITOFP);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // fptoui '(' TypedValue 'to' Type ')'
  private static boolean Value_25(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_25")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPTOUI);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // inttoptr '(' TypedValue 'to' Type ')'
  private static boolean Value_26(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_26")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTTOPTR);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ptrtoint '(' TypedValue 'to' Type ')'
  private static boolean Value_27(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_27")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PTRTOINT);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, "to");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // insertvalue '(' Value ',' Value (',' Index )+ ')'
  private static boolean Value_28(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_28")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INSERTVALUE);
    r = r && consumeToken(b, "(");
    r = r && Value(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Value(b, l + 1);
    r = r && Value_28_5(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Index )+
  private static boolean Value_28_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_28_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Value_28_5_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!Value_28_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Value_28_5", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' Index
  private static boolean Value_28_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_28_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Index(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // icmp IntPredicate '(' TypedValue ',' TypedValue ')'
  private static boolean Value_29(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_29")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ICMP);
    r = r && IntPredicate(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // fcmp FPPredicate '(' TypedValue ',' TypedValue ')'
  private static boolean Value_30(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_30")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FCMP);
    r = r && FPPredicate(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // fadd '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_31(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_31")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FADD);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // fsub '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_32")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FSUB);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // add nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_33(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_33")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ADD);
    r = r && Value_33_1(b, l + 1);
    r = r && Value_33_2(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Value_33_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_33_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Value_33_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_33_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // sub nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_34(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_34")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUB);
    r = r && Value_34_1(b, l + 1);
    r = r && Value_34_2(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Value_34_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_34_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Value_34_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_34_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // mul nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_35(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_35")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    r = r && Value_35_1(b, l + 1);
    r = r && Value_35_2(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Value_35_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_35_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Value_35_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_35_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // shl nuw? nsw? '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_36(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_36")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHL);
    r = r && Value_36_1(b, l + 1);
    r = r && Value_36_2(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // nuw?
  private static boolean Value_36_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_36_1")) return false;
    consumeToken(b, NUW);
    return true;
  }

  // nsw?
  private static boolean Value_36_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_36_2")) return false;
    consumeToken(b, NSW);
    return true;
  }

  // fmul '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_37(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_37")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FMUL);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // udiv '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_38(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_38")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UDIV);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // sdiv '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_39(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_39")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SDIV);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // fdiv '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_40(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_40")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FDIV);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // urem '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_41(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_41")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UREM);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // srem '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_42(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_42")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SREM);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // frem '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_43(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_43")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FREM);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // lshl '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_44(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_44")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSHL);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ashr '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_45(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_45")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASHR);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // and '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_46(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_46")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // or '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_47(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_47")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // xor '(' TypedValue ',' TypedValue  ')'
  private static boolean Value_48(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_48")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, XOR);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // getelementptr inbounds? '(' Type ',' TypedValue (',' TypedValue)* ')'
  private static boolean Value_49(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_49")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GETELEMENTPTR);
    r = r && Value_49_1(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && Value_49_6(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // inbounds?
  private static boolean Value_49_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_49_1")) return false;
    consumeToken(b, INBOUNDS);
    return true;
  }

  // (',' TypedValue)*
  private static boolean Value_49_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_49_6")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Value_49_6_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Value_49_6", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Value_49_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_49_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // getelementptr inbounds? '(' TypedValue (',' TypedValue)* ')'
  private static boolean Value_50(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_50")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GETELEMENTPTR);
    r = r && Value_50_1(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && Value_50_4(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // inbounds?
  private static boolean Value_50_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_50_1")) return false;
    consumeToken(b, INBOUNDS);
    return true;
  }

  // (',' TypedValue)*
  private static boolean Value_50_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_50_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Value_50_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Value_50_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypedValue
  private static boolean Value_50_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_50_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shufflevector '(' TypedValue ',' TypedValue ',' TypedValue ')'
  private static boolean Value_51(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_51")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHUFFLEVECTOR);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // insertelement '(' TypedValue ',' TypedValue ',' TypedValue ')'
  private static boolean Value_52(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_52")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INSERTELEMENT);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // extractelement '(' TypedValue ',' TypedValue ')'
  private static boolean Value_53(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_53")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTRACTELEMENT);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // select '(' TypedValue ',' TypedValue ','TypedValue ')'
  private static boolean Value_54(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value_54")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SELECT);
    r = r && consumeToken(b, "(");
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && TypedValue(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // default
  //                     |   hidden
  //                     |   protected
  public static boolean Visibility(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Visibility")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<visibility>");
    r = consumeToken(b, DEFAULT);
    if (!r) r = consumeToken(b, HIDDEN);
    if (!r) r = consumeToken(b, PROTECTED);
    exit_section_(b, l, m, VISIBILITY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression root: Type
  // Operator priority table:
  // 0: ATOM(PrimitiveType)
  // 1: ATOM(UserDefinedType)
  // 2: PREFIX(ArrayType)
  // 3: ATOM(StructureType)
  // 4: ATOM(PackedStructureType)
  // 5: PREFIX(VectorType)
  // 6: POSTFIX(PointerType)
  // 7: POSTFIX(FunctionType)
  // 8: POSTFIX(AddressSpaceType)
  public static boolean Type(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Type")) return false;
    addVariant(b, "<type>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<type>");
    r = PrimitiveType(b, l + 1);
    if (!r) r = UserDefinedType(b, l + 1);
    if (!r) r = ArrayType(b, l + 1);
    if (!r) r = StructureType(b, l + 1);
    if (!r) r = PackedStructureType(b, l + 1);
    if (!r) r = VectorType(b, l + 1);
    p = r;
    r = r && Type_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Type_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Type_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 6 && consumeTokenSmart(b, ASTERISK)) {
        r = true;
        exit_section_(b, l, m, POINTER_TYPE, r, true, null);
      }
      else if (g < 7 && FunctionType_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, FUNCTION_TYPE, r, true, null);
      }
      else if (g < 8 && AddressSpaceType_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, ADDRESS_SPACE_TYPE, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // TYPE_LITERAL
  public static boolean PrimitiveType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimitiveType")) return false;
    if (!nextTokenIsFast(b, TYPE_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, TYPE_LITERAL);
    exit_section_(b, m, PRIMITIVE_TYPE, r);
    return r;
  }

  // LOCAL_IDENTIFIER
  public static boolean UserDefinedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UserDefinedType")) return false;
    if (!nextTokenIsFast(b, LOCAL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LOCAL_IDENTIFIER);
    exit_section_(b, m, USER_DEFINED_TYPE, r);
    return r;
  }

  public static boolean ArrayType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayType")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = ArrayType_0(b, l + 1);
    p = r;
    r = p && Type(b, l, 2);
    r = p && report_error_(b, consumeToken(b, "]")) && r;
    exit_section_(b, l, m, ARRAY_TYPE, r, p, null);
    return r || p;
  }

  // '[' INTERGER_LITERAL 'x'
  private static boolean ArrayType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, "[");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, TIMES);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' (Type (',' Type)*)? '}'
  public static boolean StructureType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructureType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<structure type>");
    r = consumeTokenSmart(b, "{");
    r = r && StructureType_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, STRUCTURE_TYPE, r, false, null);
    return r;
  }

  // (Type (',' Type)*)?
  private static boolean StructureType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructureType_1")) return false;
    StructureType_1_0(b, l + 1);
    return true;
  }

  // Type (',' Type)*
  private static boolean StructureType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructureType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1, -1);
    r = r && StructureType_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Type)*
  private static boolean StructureType_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructureType_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!StructureType_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructureType_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Type
  private static boolean StructureType_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructureType_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<' ('{'  Type (',' Type)* '}')? '>'
  public static boolean PackedStructureType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PackedStructureType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<packed structure type>");
    r = consumeTokenSmart(b, "<");
    r = r && PackedStructureType_1(b, l + 1);
    r = r && consumeToken(b, ">");
    exit_section_(b, l, m, PACKED_STRUCTURE_TYPE, r, false, null);
    return r;
  }

  // ('{'  Type (',' Type)* '}')?
  private static boolean PackedStructureType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PackedStructureType_1")) return false;
    PackedStructureType_1_0(b, l + 1);
    return true;
  }

  // '{'  Type (',' Type)* '}'
  private static boolean PackedStructureType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PackedStructureType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, "{");
    r = r && Type(b, l + 1, -1);
    r = r && PackedStructureType_1_0_2(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Type)*
  private static boolean PackedStructureType_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PackedStructureType_1_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!PackedStructureType_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PackedStructureType_1_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Type
  private static boolean PackedStructureType_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PackedStructureType_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean VectorType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VectorType")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = VectorType_0(b, l + 1);
    p = r;
    r = p && Type(b, l, 5);
    r = p && report_error_(b, consumeToken(b, ">")) && r;
    exit_section_(b, l, m, VECTOR_TYPE, r, p, null);
    return r || p;
  }

  // '<' INTERGER_LITERAL 'x'
  private static boolean VectorType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VectorType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, "<");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, TIMES);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' (Type ',')* (Type|'...')? ')'
  private static boolean FunctionType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, "(");
    r = r && FunctionType_0_1(b, l + 1);
    r = r && FunctionType_0_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (Type ',')*
  private static boolean FunctionType_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionType_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionType_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // Type ','
  private static boolean FunctionType_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1, -1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Type|'...')?
  private static boolean FunctionType_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0_2")) return false;
    FunctionType_0_2_0(b, l + 1);
    return true;
  }

  // Type|'...'
  private static boolean FunctionType_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1, -1);
    if (!r) r = consumeTokenSmart(b, "...");
    exit_section_(b, m, null, r);
    return r;
  }

  // addrspace '(' INTERGER_LITERAL ')' '*'
  private static boolean AddressSpaceType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AddressSpaceType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ADDRSPACE);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, INTERGER_LITERAL);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, ASTERISK);
    exit_section_(b, m, null, r);
    return r;
  }

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ADDRESS_SPACE) {
      r = AddressSpace(b, 0);
    } else if (t == ADDRESS_SPACE_TYPE) {
      r = Type(b, 0, 7);
    } else if (t == ALIGNMENT) {
      r = Alignment(b, 0);
    } else if (t == ARGUMENT) {
      r = Argument(b, 0);
    } else if (t == ARGUMENT_LIST) {
      r = ArgumentList(b, 0);
    } else if (t == ARRAY_TYPE) {
      r = ArrayType(b, 0);
    } else if (t == ATOMIC_ORDERING) {
      r = AtomicOrdering(b, 0);
    } else if (t == BASIC_BLOCK) {
      r = BasicBlock(b, 0);
    } else if (t == CALLING_CONVENTION) {
      r = CallingConvention(b, 0);
    } else if (t == CLAUSE) {
      r = Clause(b, 0);
    } else if (t == COMDAT) {
      r = Comdat(b, 0);
    } else if (t == DLL_STORAGE_CLASS) {
      r = DllStorageClass(b, 0);
    } else if (t == ENTITY) {
      r = Entity(b, 0);
    } else if (t == FP_PREDICATE) {
      r = FPPredicate(b, 0);
    } else if (t == FAST_MATHS_FLAG) {
      r = FastMathsFlag(b, 0);
    } else if (t == FLOAT_LITERAL) {
      r = FloatLiteral(b, 0);
    } else if (t == FUNCTION_ATTRIBUTE) {
      r = FunctionAttribute(b, 0);
    } else if (t == FUNCTION_BODY) {
      r = FunctionBody(b, 0);
    } else if (t == FUNCTION_HEADER) {
      r = FunctionHeader(b, 0);
    } else if (t == FUNCTION_TYPE) {
      r = Type(b, 0, 6);
    } else if (t == INDEX) {
      r = Index(b, 0);
    } else if (t == INSTRUCTION) {
      r = Instruction(b, 0);
    } else if (t == INT_PREDICATE) {
      r = IntPredicate(b, 0);
    } else if (t == LINKAGE) {
      r = Linkage(b, 0);
    } else if (t == METADATA) {
      r = Metadata(b, 0);
    } else if (t == OPERAND_BUNDLE) {
      r = OperandBundle(b, 0);
    } else if (t == OPERATION) {
      r = Operation(b, 0);
    } else if (t == PACKED_STRUCTURE_TYPE) {
      r = PackedStructureType(b, 0);
    } else if (t == PARAMETER) {
      r = Parameter(b, 0);
    } else if (t == PARAMETER_ATTRIBUTE) {
      r = ParameterAttribute(b, 0);
    } else if (t == PARAMETER_LIST) {
      r = ParameterList(b, 0);
    } else if (t == POINTER_TYPE) {
      r = Type(b, 0, 5);
    } else if (t == PRIMITIVE_TYPE) {
      r = PrimitiveType(b, 0);
    } else if (t == RETURN_ATTRIBUTE) {
      r = ReturnAttribute(b, 0);
    } else if (t == SCOPE) {
      r = Scope(b, 0);
    } else if (t == SECTION) {
      r = Section(b, 0);
    } else if (t == SELECTION_KIND) {
      r = SelectionKind(b, 0);
    } else if (t == STATEMENT) {
      r = Statement(b, 0);
    } else if (t == STRUCTURE_TYPE) {
      r = StructureType(b, 0);
    } else if (t == THREAD_LOCAL_STORAGE) {
      r = ThreadLocalStorage(b, 0);
    } else if (t == TYPE) {
      r = Type(b, 0, -1);
    } else if (t == TYPED_VALUE) {
      r = TypedValue(b, 0);
    } else if (t == USER_DEFINED_TYPE) {
      r = UserDefinedType(b, 0);
    } else if (t == VALUE) {
      r = Value(b, 0);
    } else if (t == VECTOR_TYPE) {
      r = VectorType(b, 0);
    } else if (t == VISIBILITY) {
      r = Visibility(b, 0);
    } else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Module(b, l + 1);
  }

}
