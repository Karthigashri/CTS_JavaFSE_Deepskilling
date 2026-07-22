import React from "react";

//Odd Players using Destructuring
export function OddPlayers([first, , third, , fifth]) {
  return (
    <ul>
      <li>First : {first}</li>
      <li>Third : {third}</li>
      <li>Fifth : {fifth}</li>
    </ul>
  );
}

//Even Players using Destructuring
export function EvenPlayers([, second, , fourth, , sixth]) {
  return (
    <ul>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </ul>
  );
}

//Merge Arrays using Spread Operator
const T20Players = [
  "First Player",
  "Second Player",
  "Third Player",
];

const RanjiTrophyPlayers = [
  "Fourth Player",
  "Fifth Player",
  "Sixth Player",
];

export const IndianPlayers = [
  ...T20Players,
  ...RanjiTrophyPlayers,
];

//Display merged players
export function ListofIndianPlayers(props) {
  return (
    <ul>
      {props.IndianPlayers.map((player, index) => (
        <li key={index}>Mr. {player}</li>
      ))}
    </ul>
  );
}