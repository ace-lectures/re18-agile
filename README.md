# Reconciling Requirements and Continuous Integration in an Agile Context  

  * Version: 1.0
  * Authors: 
    * [Sébastien Mosser](mosser@i3s.unice.fr) (Université Côte d'Azur, CNRS, I3S, France)
    * [Jean-Michel Bruel](bruel@irit.fr) (Université de Toulouse, IRIT/CNRS, France)
  * Instances of this tutorial
    * Sparks internal seminar: 02/08/18, 08:30AM, _Salle du conseil_;
    * [Requirement Engineering'18](http://www.re18.org/program/conferenceProgramMonday.html#T02): 
      20/08/18, 2PM, Room KC 301
  * Reviewers: 
    * Philippe Collet, Laure Gonnord
    
    
## Objectives

In this context we propose a tutorial on Requirements in an Agile context that aims at exploring the boundaries between 
requirements, specifications, stories, scenarios and tests. Built on top of the presenters experience with respect to 
agility (taught since 2012 using a project-based approach), it follows the recent work started in the requirement 
engineering community about agility, from a practical point of view [1,2,3,4]. 

Revisiting requirements elicitation and bridging the gap between traditional requirements engineering and modern 
software development (highly based on continuous integration and tests), this tutorial will demonstrate how to \
operationalize a fully-fledged tool chain going from user stories to automated acceptance testing using open-source 
tools. This is applicable to industrial practitioners as we will rely on state of the art tools, and link agile 
requirements to formal requirement engineering methods.
    
## Logistics

  - Participants will work in pairs. They need to bring:
    - at least one laptop where the following tools are installed (JDK 1.8, maven, docker, git).
    - pens and papers to write user stories

## Contents

This tutorial is organized as a 3 hours session, where we will work on a simplified version of the `Poker Hands` kata 
available on the [coding dojo](https://codingdojo.org/kata/PokerHands/) website. 

This repository contains the following material:

  - `tutorial`: A step-by-step description of this tutorial, for participants;
  - `organizers`: material for organizers.
  - `src`: the source code use to kick-start the implementation and test part of the tutorial
  - `ci`: a turnkey lightweight CI (Continuous Integration) stack
  - `publications`: papers associated to this tutorial
  - `agile-devops-tutorial.pdf`: The slides used to support the tutorial
  
  
## Where to start?

  - Organizers: read the [organizer Guide](./organizers/README.md) to prepare your session;
  - Participants: Go to the [first step](./tutorial/steps/step1.md)! 
  
## How to contribute to this tutorial?

  - As a participant, give feedback tot the organizer about the contents of the tutorial, by completing the _RoTI_ 
    (Return on Time Invested) board when leaving the room and interacting with the organizers after.
  - As an organizer, do not hesitate to send us a pull request based on your own experience when instantiating this 
    tutorial in your context

## Authors' biography

 **Jean-Michel Bruel** is Full Professor at the University of Toulouse (France). He is leading the SM@RT team, 
 specialized in models and language engineering. He has animated several tutorials at MODELS or RE. He has been 
 teaching Agile Methods and Model-Based Systems Engineering for more than 10 years. One of its research interest is to 
 define the semantics of traceability links.
 
 **Sébastien Mosser** is Associate Professor at Université Côte d’Azur (France). He is coordinating the Software 
 Architecture specialization of the Computer Science MSc, and teaches soft- ware engineering courses at both graduate 
 and undergraduate levels. His research interests cover software development and separation of concerns mechanisms.

## References

  1. R. Kasauli, G. Liebel, E. Knauss, S. Gopakumar, and B. Kanagwa, “_Requirements engineering challenges in 
     large-scale agile system development_”, RE 2017: 352–361.
  2. S. Saito, Y. Iimura, A. K. Massey, and A. I. Anton, “_How much undocumented knowledge is there in agile software 
     development?: Case study on industrial project using issue tracking system and version control system_” 
     RE 2017: 194–203.
  3. Garm Lucassen, Fabiano Dalpiaz, Jan Martijn E. M. van der Werf, Sjaak Brinkkemper: "_The Use and Effectiveness of 
      User Stories in Practice_". REFSQ 2016: 205-222 
  4. Garm Lucassen, Fabiano Dalpiaz, Jan Martijn E. M. van der Werf, Sjaak Brinkkemper: "_Improving agile 
      requirements: the Quality User Story framework and tool_". Requir. Eng. 21(3): 383-403 (2016)
