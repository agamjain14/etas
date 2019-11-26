(PlayKeys.playExternalizedResources in Compile) := (PlayKeys.playExternalizedResources in Compile).value.filter {
  case (_, "reference.conf") => false
  case _ => true
}