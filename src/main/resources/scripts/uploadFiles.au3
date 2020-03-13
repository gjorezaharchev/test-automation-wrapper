#include <IE.au3>
#include <MsgBoxConstants.au3>
; Internet Explorer is partly integrated in shell.application
$oShell = ObjCreate("shell.application") ; Get the Windows Shell Object
$oShellWindows=$oShell.windows   ; Get the collection of open shell Windows
$MyIExplorer=""
for $Window in $oShellWindows    ; Count all existing shell windows
  ; Note: Internet Explorer appends a slash to the URL in it's window name
  if StringInStr($Window.LocationURL,"http://") then
      $MyIExplorer=$Window
      exitloop
  endif
next
$oForm = _IEGetObjByName ($MyIExplorer, "UploadedFile")
_IEAction($oForm, "click")

$winName = $CmdLine[3]
WinActivate($winName);
Local $file = $CmdLine[2]
Local $path = $CmdLine[1]

Local $sFile = StringReplace($file, "'", '"')

ControlSetText($winName, "", "Edit1", $path )
ControlClick($winName, "", "Button1")
Sleep(3000)
ControlSetText($winName, "", "Edit1", $sFile )
ControlClick($winName, "", "Button1")

