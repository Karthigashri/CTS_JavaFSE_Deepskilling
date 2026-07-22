import React from "react";

//Display all players
export function ListofPlayers(props) {
  return (
    <ul>
      {props.players.map((item, index) => (
        <li key={index}>
          Mr. {item.name} {item.score}
        </li>
      ))}
    </ul>
  );
}

//Display players with score <=70
export function ScoreBelow70(props) {

  const players70 = props.players.filter(
    (item) => item.score <= 70
  );

  return (
    <ul>
      {players70.map((item, index) => (
        <li key={index}>
          Mr. {item.name} {item.score}
        </li>
      ))}
    </ul>
  );
}